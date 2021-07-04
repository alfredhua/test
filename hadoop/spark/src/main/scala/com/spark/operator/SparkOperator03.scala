package com.spark.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object SparkOperator03 {


  def main(args: Array[String]): Unit = {
    //TODO 准备环境
    val conf = new SparkConf().setMaster("local[*]").setAppName("operator")
    val sc=new SparkContext(conf)
    val rdd = sc.makeRDD(List(1,2,3,4),2)


    val mapRDD:RDD[Int] = rdd.mapPartitions(item => {
      item.map(_ * 2)
    })
    mapRDD.collect().foreach(println)

    sc.stop()
  }

}
