package com.flink.test;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

/**
 * @author guozhenhua
 * @date 2021/07/08
 */
public class WorkCount {

    public static void main(String[] args) throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        DataSet<String> inputDataSet = env.readTextFile("hadoop/datas/wordcount.txt");

        DataSet<Tuple2<String, Integer>> sum = inputDataSet.flatMap(new MyFlatMapFunction()).groupBy(0).sum(1);

        sum.print();

    }


   public static class MyFlatMapFunction implements FlatMapFunction<String, Tuple2<String,Integer>> {

        @Override
        public void flatMap(String value, Collector<Tuple2<String, Integer>> out) {
            String[] words = value.split(" ");

            for (String word : words) {
                out.collect(new Tuple2<>(
                        word,1
                ));
            }

        }
    }


}
