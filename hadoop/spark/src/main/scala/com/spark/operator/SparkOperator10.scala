package com.spark.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object SparkOperator10 {


  def main(args: Array[String]): Unit = {
    //TODO 准备环境
    val conf = new SparkConf().setMaster("local[*]").setAppName("operator")
    val sc=new SparkContext(conf)
    val rdd = sc.makeRDD(List(1,2,3,4,5),2)

    //将数据源中每个数据进行分组判断，根据返回的分组key进行分组
    def groupFunction(num:Int):Int={
        num % 2
    }

    val group = rdd.groupBy(groupFunction)

    group.collect().foreach(println)

    sc.stop()
  }

}
