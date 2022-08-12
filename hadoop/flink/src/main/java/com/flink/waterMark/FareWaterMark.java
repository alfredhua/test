package com.flink.waterMark;

import com.flink.connect.entity.TaxiFare;
import com.flink.connect.sources.TaxiFareGenerator;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.streaming.api.datastream.AllWindowedStream;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.streaming.api.functions.sink.PrintSinkFunction;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;
import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;
import scala.Tuple3;

public class FareWaterMark {

    private SourceFunction<TaxiFare> source;
    private SinkFunction<Tuple3> sink;

    public FareWaterMark(SourceFunction<TaxiFare> source, SinkFunction<Tuple3> sink) {
        this.source = source;
        this.sink = sink;
    }

    public void execute() throws Exception {
        StreamExecutionEnvironment executionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<TaxiFare> sourceDataStream = executionEnvironment.addSource(source).name("source");
        DataStream<TaxiFare> timestampsAndWatermarks =
                sourceDataStream.assignTimestampsAndWatermarks(WatermarkStrategy.<TaxiFare>forMonotonousTimestamps().withTimestampAssigner((fare, t) -> fare.getEventTimeMillis()));

        timestampsAndWatermarks.keyBy((TaxiFare fare) -> fare.driverId).window(TumblingEventTimeWindows.of(Time.hours(1))).process(new AddTips());

        executionEnvironment.execute("hours");
    }


    public static class AddTips extends ProcessWindowFunction<TaxiFare, Tuple3<Long, Long, Float>, Long, TimeWindow> {
        @Override
        public void process(Long aLong, ProcessWindowFunction<TaxiFare, Tuple3<Long, Long, Float>, Long, TimeWindow>.Context context, Iterable<TaxiFare> elements, Collector<Tuple3<Long, Long, Float>> out) throws Exception {

        }
    }
    public static void main(String[] args) throws Exception {
        FareWaterMark fareWaterMark = new FareWaterMark(new TaxiFareGenerator(), new PrintSinkFunction<>());
        fareWaterMark.execute();
    }

}
