package com.flink.tran;

import com.flink.help.Event;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class TranReturnTypeTest {
    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        DataStreamSource<Event> stream = env.fromElements(
                new Event("Mary", "./home", 1000L),
                new Event("Bob", "./cart", 2000L)
        );

//       stream.map(event -> Tuple2.of(event.user, 1L))
//                .returns(Types.TUPLE(Types.STRING, Types.LONG)).print();
//
        stream.map((MapFunction<Event, Tuple2<String, Long>>) value -> Tuple2.of(value.user,1L))
                .returns(Types.TUPLE(Types.STRING, Types.LONG)).print();

        env.execute();
    }
}
