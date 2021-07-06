package com.spark.core.operator

import org.apache.spark.{SparkConf, SparkContext}

object SparkOperator05 {


  def main(args: Array[String]): Unit = {
    //TODO 准备环境
    val conf = new SparkConf().setMaster("local[*]").setAppName("operator")
    val sc=new SparkContext(conf)
    val rdd = sc.makeRDD(List(List(1,2),List(3),List(4,5)),2)
    val rddList = rdd.flatMap(list=>list)
    rddList.collect().foreach(println)

    sc.stop()
  }

}
