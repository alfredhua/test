package com.flink.demo.stock;

import org.apache.flink.streaming.api.functions.sink.SinkFunction;

public class StockSink implements SinkFunction<StockPrice> {

    @Override
    public void invoke(StockPrice value, Context context) throws Exception {
        SinkFunction.super.invoke(value, context);
    }
}
