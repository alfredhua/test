package com.spark.operator

import org.apache.spark.{SparkConf, SparkContext}

object SparkOperator13 {


  def main(args: Array[String]): Unit = {
    //TODO 准备环境
    val conf = new SparkConf().setMaster("local[*]").setAppName("operator")
    val sc=new SparkContext(conf)
    val rdd = sc.makeRDD(List(1,2,3,4,5,6,7,8,9,10))

   print( rdd.sample(false,0.4,1).collect().mkString(","))


    //将数据源中每个数据进行分组判断，根据返回的分组key进行分组
    sc.stop()
  }

}
