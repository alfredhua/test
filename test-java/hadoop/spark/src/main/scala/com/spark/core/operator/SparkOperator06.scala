package com.spark.core.operator

import org.apache.spark.{SparkConf, SparkContext}

object SparkOperator06 {


  def main(args: Array[String]): Unit = {
    //TODO 准备环境
    val conf = new SparkConf().setMaster("local[*]").setAppName("operator")
    val sc=new SparkContext(conf)
    val rdd = sc.makeRDD(List("hello scala","hello spark"),2)
    val rddList = rdd.flatMap(s=>{
      s.split(" ")
    })

    rddList.collect().foreach(println)

    sc.stop()
  }

}
