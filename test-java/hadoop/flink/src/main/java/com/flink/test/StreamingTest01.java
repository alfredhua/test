package com.flink.test;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author guozhenhua
 * @date 2021/07/08
 */
public class StreamingTest01 {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<String> inputDataSet = env.readTextFile("hadoop/datas/wordcount.txt");

        inputDataSet.flatMap(new WorkCount.MyFlatMapFunction()).keyBy(0).sum(1).print();

        env.execute();
    }
}

