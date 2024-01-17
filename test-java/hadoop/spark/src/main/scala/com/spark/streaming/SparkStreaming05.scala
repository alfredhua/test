package com.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * 自定义数据采集器
 */
object SparkStreaming05 {


  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("operator")

    val ssc = new StreamingContext(conf,Seconds(3))

    ssc.checkpoint("cp")
    val datas = ssc.socketTextStream("localhost", 9999)

    val value = datas.map((_, 1))

    val value1 = value.updateStateByKey((seq: Seq[Int], opt: Option[Int]) => {
      opt
    })

    value1.print()
    ssc.start()
    ssc.awaitTermination()
  }


}
