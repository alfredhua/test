package com.flink.sql;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.types.Row;

/**
 * @author hua
 * @date 2022/9/18
 */
public class FlinkSQLDistinctExample {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment blinkStreamEnv = StreamExecutionEnvironment.getExecutionEnvironment();
        blinkStreamEnv.setParallelism(1);

        EnvironmentSettings blinkStreamSettings = EnvironmentSettings.newInstance()
                .useBlinkPlanner()
                .inStreamingMode().build();

        StreamTableEnvironment blinkStreamTableEnv =
                StreamTableEnvironment.create(blinkStreamEnv, blinkStreamSettings);

        String ddlSource = """ 
                create table user_behavior (
                    user_id BIGINT,
                    item_id BIGINT,
                    category_id BIGINT,
                    behavior STRING,
                    ts TIMESTAMP(3)
                ) WITH (
                   'connector.type' = 'kafka',
                   'connector.version' = '0.11',
                   'connector.topic' = 'user_behavior',
                   'connector.startup-mode' = 'latest-offset',
                   'connector.properties.zookeeper.connect' = 'localhost:2181',
                   'connector.properties.bootstrap.servers' = 'localhost:9092',
                   'format.type' = 'json'
                )
                """;
        blinkStreamTableEnv.executeSql(ddlSource);

        String countSql = "select user_id, count(user_id) from user_behavior group by user_id";

        Table countTable = blinkStreamTableEnv.sqlQuery(countSql);
        blinkStreamTableEnv.toRetractStream(countTable, Row.class).print();

        String distinctSql = "select distinct(user_id) from user_behavior";
        Table table = blinkStreamTableEnv.sqlQuery(distinctSql);
        blinkStreamTableEnv.toRetractStream(table,Row.class).print("=========");

    }
}
