package com.flink.source;

import com.flink.help.Event;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.ArrayList;
import java.util.List;

public class SourceTest {
    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        DataStreamSource<String> strean1 = env.readTextFile("input/clicks.csv");

        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        DataStreamSource<Integer> numsStream = env.fromCollection(nums);


        List<Event> events = new ArrayList<>();
        events.add(new Event("Mary","./home",1000L));
        events.add(new Event("Bob","./cart",2000L));
        DataStreamSource<Event> eventDataStreamSource = env.fromCollection(events);

        env.socketTextStream("localhost",7777);

        numsStream.print("4");

        env.execute();

    }
}
