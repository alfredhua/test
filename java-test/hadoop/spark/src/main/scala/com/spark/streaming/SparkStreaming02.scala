package com.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.receiver.Receiver
import org.apache.spark.streaming.{Seconds, StreamingContext}

import java.util.Random

/**
 * 自定义数据采集器
 */
object SparkStreaming02 {


  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("operator")

    val ssc = new StreamingContext(conf,Seconds(3))

    ssc.receiverStream(new MyReceiver()).print()
    ssc.start()
    ssc.awaitTermination()
  }


  class  MyReceiver extends Receiver[String](StorageLevel.MEMORY_ONLY){
    private var flag = true;
    override def onStart(): Unit = {

      new Thread(()=>{
        while(flag){
          val message= new Random().nextInt().toString
          store(message)
          Thread.sleep(1000)
        }
      }).start()
    }

    override def onStop(): Unit = {
       flag=false
    }
  }

}
