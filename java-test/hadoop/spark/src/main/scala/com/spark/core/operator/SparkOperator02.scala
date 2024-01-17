package com.spark.core.operator

import org.apache.spark.{SparkConf, SparkContext}

object SparkOperator02 {


  def main(args: Array[String]): Unit = {
    //TODO 准备环境
    val conf = new SparkConf().setMaster("local[*]").setAppName("operator")
    val sc=new SparkContext(conf)
    val rdd = sc.textFile("hadoop/datas/apache.log")

    val urlRDD = rdd.map(line => {
      val data = line.split(" ")
      data(6)
    })

    urlRDD.collect().foreach(println)



    sc.stop()
  }

}
