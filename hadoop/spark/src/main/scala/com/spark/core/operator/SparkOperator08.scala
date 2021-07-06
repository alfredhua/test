package com.spark.core.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object SparkOperator08 {


  def main(args: Array[String]): Unit = {
    //TODO 准备环境
    val conf = new SparkConf().setMaster("local[*]").setAppName("operator")
    val sc=new SparkContext(conf)
    val rdd = sc.makeRDD(List(1,2,3,4,5),2)

    val rddList:RDD[Array[Int]] = rdd.glom()
    rddList.collect().foreach(data=>{println(data.mkString(","))})

    sc.stop()
  }

}
