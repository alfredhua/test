package com.flink.fraud;

import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.KeyedProcessFunction;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;
import org.apache.flink.util.Collector;
import org.apache.flink.walkthrough.common.entity.Alert;
import org.apache.flink.walkthrough.common.entity.Transaction;
import org.apache.flink.walkthrough.common.sink.AlertSink;
import org.apache.flink.walkthrough.common.source.TransactionSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FraudDetectionJob {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment executionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<Transaction> transactions = executionEnvironment.addSource(new TransactionSource()).name("transactions");
        DataStream<String> alert = transactions.keyBy(Transaction::getAccountId).process(new FraudDetector()).name("fraud-detector");
        alert.addSink(new AlertSinkConsumer()).name("send-alerts");
        executionEnvironment.execute("fraud detection");
    }
    static class AlertSinkConsumer implements SinkFunction<String> {

        private static final long serialVersionUID = 1L;

        private static final Logger LOG = LoggerFactory.getLogger(org.apache.flink.walkthrough.common.sink.AlertSink.class);

        @Override
        public void invoke(String value, Context context) {
            System.out.println("alert info value:"+value);
        }
    }

    static class FraudDetector extends KeyedProcessFunction<Long,Transaction, String>{
        private static final long serialVersionUID = 1L;

        private static final double SMALL_AMOUNT = 1.00;
        private static final double LARGE_AMOUNT = 500.00;
        private static final long ONE_MINUTE = 60 * 1000;

        private transient ValueState<Boolean> flagState;

        @Override
        public void open(Configuration parameters) throws Exception {
            ValueStateDescriptor<Boolean> flagDescriptor = new ValueStateDescriptor<>( "flag", Types.BOOLEAN);
            flagState = getRuntimeContext().getState(flagDescriptor);
        }

        @Override
        public void processElement(Transaction value, KeyedProcessFunction<Long, Transaction, String>.Context ctx, Collector<String> out) throws Exception {
            Boolean lastTransactionWasSmall = flagState.value();
            if(lastTransactionWasSmall!=null){
                if (value.getAmount()>LARGE_AMOUNT){
                    out.collect("输出id："+value.getAccountId()+",金额："+value.getAmount()+",时间:"+value.getTimestamp());
                }
                flagState.clear();
            }
            if (value.getAmount()<SMALL_AMOUNT){
                flagState.update(true);
            }
        }
    }
}
