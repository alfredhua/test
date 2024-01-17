package com.spark.core.operator

import org.apache.spark.{SparkConf, SparkContext}

object SparkOperator14 {


  def main(args: Array[String]): Unit = {
    //TODO 准备环境
    val conf = new SparkConf().setMaster("local[*]").setAppName("operator")
    val sc=new SparkContext(conf)
    val rdd1 = sc.makeRDD(List(1,2,3,4))
    val rdd2 = sc.makeRDD(List(2,3,4,5))
    val rdd = rdd1.subtract(rdd2)

//    val rdd1 = sc.makeRDD(List(1,2,3,4))
//    val rdd2 = sc.makeRDD(List(2,3,4,5))
//    val rdd = rdd1.union(rdd2)

//    val rdd1 = sc.makeRDD(List(1,2,3,4))
//    val rdd2 = sc.makeRDD(List(2,3,4,5))
//    val rdd = rdd1.zip(rdd2)
    print( rdd.collect().mkString(","))


    //将数据源中每个数据进行分组判断，根据返回的分组key进行分组
    sc.stop()
  }

}
