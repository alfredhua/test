package com.spark.core.builder

import org.apache.spark.{SparkConf, SparkContext}

object RDDCreate {


  def main(args: Array[String]): Unit = {
    //TODO 准备环境
    val conf = new SparkConf().setMaster("local[*]").setAppName("rdd")
    val sc=new SparkContext(conf)

    //TODO 创建RDD
    //从内存中创建RDD

    var seq=Seq[Int](1,2,3,4)
//    val rdd = sc.parallelize(seq)
//    val rdd = sc.makeRDD(seq)
    val rdd=sc.textFile("datas/1.txt")
//    val rdd=sc.wholeTextFiles("datas/1.txt")


    rdd.collect().foreach(println)

    sc.stop()
  }

}
