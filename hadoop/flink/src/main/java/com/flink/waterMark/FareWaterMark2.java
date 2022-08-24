package com.flink.waterMark;

import com.flink.connect.entity.TaxiFare;
import com.flink.connect.sources.TaxiFareGenerator;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.state.MapState;
import org.apache.flink.api.common.state.MapStateDescriptor;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.TimerService;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.KeyedProcessFunction;
import org.apache.flink.streaming.api.functions.sink.PrintSinkFunction;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;
import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;
import scala.Tuple3;

public class FareWaterMark2 {

    private SourceFunction<TaxiFare> source;
    private SinkFunction<Tuple3<Long, Long, Float>> sink;

    public FareWaterMark2(SourceFunction<TaxiFare> source, SinkFunction<Tuple3<Long,Long,Float>> sink) {
        this.source = source;
        this.sink = sink;
    }

    public void execute() throws Exception {
        StreamExecutionEnvironment executionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<TaxiFare> sourceDataStream = executionEnvironment.addSource(source).name("source");
        DataStream<TaxiFare> timestampsAndWatermarks =
                sourceDataStream.assignTimestampsAndWatermarks(WatermarkStrategy.<TaxiFare>forMonotonousTimestamps().withTimestampAssigner((fare, t) -> fare.getEventTimeMillis()));

        DataStream<Tuple3<Long, Long, Float>> process = timestampsAndWatermarks
                .keyBy((TaxiFare fare) -> fare.driverId)
//                .window(TumblingEventTimeWindows.of(Time.hours(1)))
                .process(new PseudoWindow(Time.hours(1)));
        process.addSink(sink);
        executionEnvironment.execute("hours");
    }


    public static class PseudoWindow extends KeyedProcessFunction<TaxiFare, TaxiFare,Tuple3<Long, Long, Float>> {

        private final long durationMsec;

        public PseudoWindow(Time duration) {
            this.durationMsec = duration.toMilliseconds();
        }
        // 每个窗口都持有托管的 Keyed state 的入口，并且根据窗口的结束时间执行 keyed 策略。
        // 每个司机都有一个单独的MapState对象。
        private transient MapState<Long, Float> sumOfTips;
        @Override
        public void onTimer(long timestamp, KeyedProcessFunction<TaxiFare, TaxiFare, Tuple3<Long, Long, Float>>.OnTimerContext ctx, Collector<Tuple3<Long, Long, Float>> out) throws Exception {
            super.onTimer(timestamp, ctx, out);
        }

        @Override
        public void open(Configuration parameters) throws Exception {
            MapStateDescriptor<Long, Float> sumOfTipsDe = new MapStateDescriptor<>("sumOfTips", Long.class, Float.class);
            sumOfTips = getRuntimeContext().getMapState(sumOfTipsDe);
        }

        @Override
        public void processElement(TaxiFare fare, KeyedProcessFunction<TaxiFare, TaxiFare, Tuple3<Long, Long, Float>>.Context ctx, Collector<Tuple3<Long, Long, Float>> out) throws Exception {
            long eventTime = fare.getEventTimeMillis();
            TimerService timerService = ctx.timerService();
            if (eventTime<=timerService.currentWatermark()){
//                ctx.output(lateFares, fare);
            }else{
                long endOfWindow = (eventTime - (eventTime % durationMsec) + durationMsec - 1);
                // 在窗口完成时将启用回调
                timerService.registerEventTimeTimer(endOfWindow);
                // 将此票价的小费添加到该窗口的总计中。
                Float sum = sumOfTips.get(endOfWindow);
                if (sum == null) {
                    sum = 0.0F;
                }
                sum += fare.tip;
                sumOfTips.put(endOfWindow, sum);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        FareWaterMark2 fareWaterMark = new FareWaterMark2(new TaxiFareGenerator(), new PrintSinkFunction<>());
        fareWaterMark.execute();
    }

}
