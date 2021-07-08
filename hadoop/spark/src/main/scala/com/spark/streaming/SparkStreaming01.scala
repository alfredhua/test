package com.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

object SparkStreaming01 {


  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("operator")

    val ssc = new StreamingContext(conf,Seconds(3))

    val stream:ReceiverInputDStream[String] = ssc.socketTextStream("localhost", 9999)
    val words = stream.flatMap(line => {
      line.split(" ")
    })

    val value = words.map((_, 1)).reduceByKey(_ + _)

    value.print()

    ssc.start()

    ssc.awaitTermination()
//    ssc.stop()
  }

}
