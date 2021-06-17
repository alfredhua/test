package com.spark.test

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object SparkStreamTest {

    def  test(): Unit ={
        var sparkConf=new SparkConf()
        sparkConf.setAppName("SparkStreamTest").setMaster("local[2]")
        val ssc = new StreamingContext(sparkConf,Seconds(1))

        val lines = ssc.socketTextStream("localhost", 9999)
        val words = lines.flatMap(_.split(" "))
        val pairs = words.map(word => (word, 1))
        val wordCounts = pairs.reduceByKey(_ + _)

        wordCounts.print()

        ssc.start()
        ssc.awaitTermination()
    }

}
