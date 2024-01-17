package com.flink.test;

import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author guozhenhua
 * @date 2021/07/08
 */
public class StreamingTest02 {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        ParameterTool parameterTool=ParameterTool.fromArgs(args);
        String host=parameterTool.get("host");
        int port=parameterTool.getInt("port");
        DataStreamSource<String> inputDataSet = env.socketTextStream(host, port);

        inputDataSet.flatMap(new WorkCount.MyFlatMapFunction()).keyBy(0).sum(1).print();

        env.execute();
    }
}

