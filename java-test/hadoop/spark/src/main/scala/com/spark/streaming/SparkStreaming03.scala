package com.spark.streaming

import kafka.serializer.StringDecoder
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.InputDStream
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.tools.nsc.interpreter.NamedParam.tuple

/**
 * 自定义数据采集器
 */
object SparkStreaming03 {


  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("operator")

    val ssc = new StreamingContext(conf,Seconds(3))

    //3.定义 Kafka 参数
    val kafkaParams: Map[String, String] = Map[String, String](
      ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG ->  "127.0.0.1:9092,",
      ConsumerConfig.GROUP_ID_CONFIG -> "demo",
      "key.deserializer" -> "org.apache.kafka.common.serialization.StringDeserializer",
      "value.deserializer" ->   "org.apache.kafka.common.serialization.StringDeserializer"
    )

    //4.读取 Kafka 数据创建 DStream
    val topic=Set("demo")
    val kafkaDStream: InputDStream[(String,String)] =
      KafkaUtils.createDirectStream[String,String,StringDecoder,StringDecoder](ssc,kafkaParams,topic)
    //5.将每条消息的 KV 取出
    kafkaDStream.map((_, 1))
      .reduceByKey(_ + _)
      .print()

    ssc.start()
    ssc.awaitTermination()
  }


}
