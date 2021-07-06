package com.spark.sql.dataframe

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

object DataFrameTest01 {

  def main(args: Array[String]): Unit = {
    //TODO 准备环境
    val conf = new SparkConf().setMaster("local[*]").setAppName("operator")
    val sc = SparkSession.builder().config(conf).getOrCreate()

    val frame:DataFrame = sc.read.json("hadoop/datas/user.json")
    frame.createTempView("user")
    val frame1 = sc.sql("select  * from user order by age desc")

    frame1.show()
    sc.stop()
  }

}
