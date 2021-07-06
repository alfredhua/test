package com.spark.core.operator

import org.apache.spark.{SparkConf, SparkContext}

object SparkOperator07 {


  def main(args: Array[String]): Unit = {
    //TODO 准备环境
    val conf = new SparkConf().setMaster("local[*]").setAppName("operator")
    val sc=new SparkContext(conf)
    val rdd = sc.makeRDD(List(List(1,2),3,List(4,5)),2)
//    val rddList = rdd.flatMap(
//      data =>{
//        data match {
//          case list:List[_] => list
//          case dat =>List(dat)
//        }
//      }
//    )
    val rddList = rdd.flatMap {
      case list: List[_] => list
      case dat => List(dat)
    }
    rddList.collect().foreach(println)

    sc.stop()
  }

}
