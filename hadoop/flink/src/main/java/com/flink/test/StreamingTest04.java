package com.flink.test;

import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

/**
 * @author guozhenhua
 * @date 2021/07/08
 */
public class StreamingTest04 {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment executionEnvironment=StreamExecutionEnvironment.getExecutionEnvironment();
        ParameterTool parameterTool = ParameterTool.fromArgs(args);
        String host = parameterTool.get("host");
        String port = parameterTool.get("port");
        DataStreamSource<String> dataStreamSource = executionEnvironment.socketTextStream(host,Integer.parseInt(port));
        dataStreamSource.flatMap((String value, Collector<Tuple2<String,Integer>> out)->{
                    String[] s = value.split(" ");
                    for (String word:s){
                        out.collect(new Tuple2<>(word,1));
                    }
                }).returns(Types.TUPLE(Types.STRING,Types.INT))
                .keyBy((Tuple2<String,Integer> t)->t.f0)
                .sum(1).print();
        executionEnvironment.execute();
    }
}

