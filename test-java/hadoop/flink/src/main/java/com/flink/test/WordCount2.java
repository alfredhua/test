package com.flink.test;

import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.AggregateOperator;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

public class WordCount2 {

    public static void main(String[] args) throws Exception {
        ExecutionEnvironment executionEnvironment = ExecutionEnvironment.getExecutionEnvironment();

        DataSet<String> dataSource = executionEnvironment.readTextFile("hadoop/datas/wordcount.txt");

        AggregateOperator<Tuple2<String, Integer>> sum = dataSource.flatMap((String value, Collector<Tuple2<String, Integer>> out) -> {
            String[] s = value.split(" ");
            for (String word : s) {
                out.collect(new Tuple2<>(word, 1));
            }
        }).returns(Types.TUPLE(Types.STRING, Types.INT)).groupBy(0).sum(1);

        sum.print();

    }
}
