package com.spark.demo

import org.apache.spark.{SparkConf, SparkContext}

class Top10 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("operator")
    val sc=new SparkContext(conf)

    val lineRDD = sc.textFile("hadoop/datas/user_visit_action.txt")

    lineRDD.map(line=>{
      val datas = line.split("_")
      datas(6)


    })



    sc.stop()
  }

}
