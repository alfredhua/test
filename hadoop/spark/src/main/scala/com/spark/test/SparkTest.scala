package com.spark.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object SparkTest {

  def main(args: Array[String]): Unit = {
    val file="/Users/guozhenhua7/temp/input/";

    val sparkConf = new SparkConf().setMaster("local").setAppName("wordCont")
    val sc= new SparkContext(sparkConf)
    val lines:RDD[String]=sc.textFile(file )
    val words:RDD[String]= lines.flatMap(_.split(" "))
    val wordGroup:RDD[(String,Iterable[String])] = words.groupBy(word=>word)

    wordGroup.map{
      case  (word,list)=>{
        (word,list.size)
      }
    }


  }


}
