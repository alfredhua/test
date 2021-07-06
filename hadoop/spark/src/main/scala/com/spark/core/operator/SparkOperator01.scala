package com.spark.core.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object SparkOperator01 {


  def main(args: Array[String]): Unit = {
    //TODO 准备环境
    val conf = new SparkConf().setMaster("local[*]").setAppName("operator")
    val sc=new SparkContext(conf)

    val rdd:RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5))

//    def mapFUnction(num:Int):Int={
//      num *2
//
//    }
//    val result = rdd.map(mapFUnction)

//    val result = rdd.map((num:Int)=>{num *2})

    val result = rdd.map(_ *2 )

    result.collect.foreach(println)


    sc.stop()
  }

}
