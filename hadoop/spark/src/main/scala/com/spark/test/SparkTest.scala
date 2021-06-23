package com.spark.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object SparkTest {

//  def main(args: Array[String]): Unit = {
//    val logFile = "/Users/guozhenhua7/workspace/self/project/.logs/site.txt" // 应该是你系统上的某些文件
//    val conf = new SparkConf().setAppName("Simple Application")
//    val sc = new SparkContext(conf)
//    val logData = sc.textFile(logFile, 2).cache()
//    val numAs = logData.filter(line => line.contains("a")).count()
//    val numBs = logData.filter(line => line.contains("b")).count()
//    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
//  }

  def main(args: Array[String]): Unit = {
    var file="/Users/guozhenhua7/temp/input/";

    val sparkConf = new SparkConf().setMaster("local").setAppName("wordCont")
    val sc= new SparkContext(sparkConf)
    val lines:RDD[String]=sc.textFile(file )
    val words:RDD[String]= lines.flatMap(_.split(" "))
    var wordGroup:RDD[(String,Iterable[String])] = words.groupBy(word=>word)

    wordGroup.map{
      case  (word,list)=>{
        (word,list.size)
      }
    }


  }


}
