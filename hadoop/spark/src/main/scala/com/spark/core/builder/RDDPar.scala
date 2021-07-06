package com.spark.core.builder

import org.apache.spark.{SparkConf, SparkContext}

object RDDPar {


  def main(args: Array[String]): Unit = {
    //TODO 准备环境
    val conf = new SparkConf().setMaster("local[*]").setAppName("rdd").set("spark.default.parallelism","5")
    val sc=new SparkContext(conf)

    //TODO 创建RDD
    //从内存中创建RDD
//    scheduler.conf.getInt("spark.default.parallelism", totalCores)
    val rdd = sc.makeRDD(List(1, 2, 3, 4))

    rdd.saveAsTextFile("output")
    rdd.collect().foreach(println)

    sc.stop()
  }

}
