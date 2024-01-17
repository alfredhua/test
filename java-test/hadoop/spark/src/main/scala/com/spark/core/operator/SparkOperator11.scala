package com.spark.core.operator

import org.apache.spark.{SparkConf, SparkContext}

object SparkOperator11 {


  def main(args: Array[String]): Unit = {
    //TODO 准备环境
    val conf = new SparkConf().setMaster("local[*]").setAppName("operator")
    val sc=new SparkContext(conf)
    val rdd = sc.makeRDD(List("hello scala","hello spark"),2)

    //将数据源中每个数据进行分组判断，根据返回的分组key进行分组
    val group = rdd.groupBy(_.charAt(0))

    group.collect().foreach(println)

    sc.stop()
  }

}
