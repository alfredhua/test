package com.kafka.test;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;
import java.util.Random;

public class Produce {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "mq.alfredhua.com:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer<>(props);
//        for(int i = 0; i < 100; i++){
//            producer.send(new ProducerRecord<>("foo", Integer.toString(i), Integer.toString(i)));
//        }

        for(int i = 0; i < 100; i++) {
            producer.send(new ProducerRecord<>("user_behavior", new Random().nextInt() + "", 1 + ""), new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    System.out.println("------------");
                }
            });
        }
        System.out.println("发送完成");
        producer.close();

    }
}
