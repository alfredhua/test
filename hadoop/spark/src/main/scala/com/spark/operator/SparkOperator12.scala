package com.spark.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import java.text.SimpleDateFormat
import java.util.Date

object SparkOperator12 {


  def main(args: Array[String]): Unit = {
    //TODO 准备环境
    val conf = new SparkConf().setMaster("local[*]").setAppName("operator")
    val sc=new SparkContext(conf)
    val rdd = sc.textFile("hadoop/datas/apache.log")

    val mapRDD:RDD[(String,Int)] = rdd.map(line => {
      val data = line.split(" ")
      val time = data(3)
      //      17/05/2015:10:05:03
      val sdf = new SimpleDateFormat("dd/mm/yyyy:HH:mm:ss")
      val date: Date = sdf.parse(time)
      val sdf1 = new SimpleDateFormat("HH")
      val hour: String = sdf1.format(date)
      (hour, 1)
    })

    val timeRDD:RDD[(String,Iterable[(String,Int)])] = mapRDD.groupBy(_._1)
    timeRDD.map{
      case (hour,iter) =>{ (hour,iter.size)}
    }.collect().foreach(println)


    //将数据源中每个数据进行分组判断，根据返回的分组key进行分组
    sc.stop()
  }

}
