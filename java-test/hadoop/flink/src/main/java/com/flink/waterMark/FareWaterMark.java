package com.flink.waterMark;

import com.flink.connect.entity.TaxiFare;
import com.flink.connect.sources.TaxiFareGenerator;
import com.flink.connect.utils.DataGenerator;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.sink.PrintSinkFunction;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;
import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;
import scala.Tuple3;

import java.time.Duration;
import java.time.Instant;

public class FareWaterMark {

    private SourceFunction<TaxiFare> source;
    private SinkFunction<Tuple3<Long, Long, Float>> sink;

    public FareWaterMark(SourceFunction<TaxiFare> source, SinkFunction<Tuple3<Long,Long,Float>> sink) {
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
                .window(TumblingEventTimeWindows.of(Time.hours(1)))
                .process(new AddTips());
        process.addSink(sink);
        executionEnvironment.execute("hours");
    }


    public static class AddTips extends ProcessWindowFunction<TaxiFare, Tuple3<Long, Long, Float>, Long, TimeWindow> {
        @Override
        public void process(Long key, ProcessWindowFunction<TaxiFare, Tuple3<Long, Long, Float>, Long, TimeWindow>.Context context, Iterable<TaxiFare> fares, Collector<Tuple3<Long, Long, Float>> out) throws Exception {
            float sumOfTips = 0F;
            for (TaxiFare f : fares) {
                sumOfTips += f.tip;
            }
            out.collect(Tuple3.apply(context.window().getEnd(),key,sumOfTips));
        }
    }
    public static void main(String[] args) throws Exception {
        FareWaterMark fareWaterMark = new FareWaterMark(new TaxiFareGenerator(), new PrintSinkFunction<>());
        fareWaterMark.execute();
    }

}
