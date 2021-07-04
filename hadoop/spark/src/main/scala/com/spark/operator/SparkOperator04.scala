package com.spark.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object SparkOperator04 {


  def main(args: Array[String]): Unit = {
    //TODO 准备环境
    val conf = new SparkConf().setMaster("local[*]").setAppName("operator")
    val sc=new SparkContext(conf)
    val rdd = sc.makeRDD(List(1,2,3,4),2)

    val map = rdd.mapPartitions(item => {
      List(item.max).iterator
    })

    map.collect().foreach(println)

    sc.stop()
  }

}
