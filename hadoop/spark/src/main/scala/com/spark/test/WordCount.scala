package com.spark.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCount {

  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local").setAppName("wordCont")

    val sc:SparkContext=new SparkContext(sparkConf)

    val lines:RDD[String]=sc.textFile("/Users/guozhenhua7/temp/input/wordCount.txt")

    val words:RDD[String] = lines.flatMap(_.split(" "))

    val a:RDD[(String,Int)] = words.map((_, 1))

    val fu: RDD[(String,Int)] = a.reduceByKey(_+ _)

    val collect:Array[(String,Int)] = fu.collect()

    collect.foreach(item =>{println(item._1+"========="+item._2)})
//    val a=sc.textFile("/Users/guozhenhua7/temp/input/wordCount.txt")
//      .flatMap(_.split(' ')).map((_,1)).reduceByKey(_+_).collect

//    for( x <- 0 until a.length){
//      println("Value of a: " + a.apply(x)._1+a.apply(x)._2)
//    }

  }


}
