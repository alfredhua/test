package com.flink.demo.stock;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class StockApplication {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment executionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<StockPrice> stockPriceDataStream = executionEnvironment.addSource(new StockSource("")).name("stock-source");
        DataStream<String> map = stockPriceDataStream.map(StockPrice::getCode);
//        map.addSink(new StockSink()).name("stock-sink");
        executionEnvironment.execute();
    }

}
