package com.flink.waterMark;

import com.flink.help.Event;
import org.apache.flink.api.common.eventtime.WatermarkGenerator;
import org.apache.flink.api.common.eventtime.WatermarkGeneratorSupplier;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.time.Duration;

/**
 * @author guozhenhua
 * @date 2022/6/16
 */
public class WaterMarkTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        DataStreamSource<Event> stream = env.fromElements(
                new Event("Mary", "./home", 1000L),
                new Event("Bob", "./cart", 2000L),
                new Event("Bobhhh", "./cart", 7000L),
                new Event("Bobassd", "./cart", 4000L)
        );
        //有序的
//        stream.assignTimestampsAndWatermarks(WatermarkStrategy.forMonotonousTimestamps());

//        stream.assignTimestampsAndWatermarks(WatermarkStrategy.forBoundedOutOfOrderness(Duration.ofMinutes(2)));

        stream.print();

        env.execute();
    }
}
