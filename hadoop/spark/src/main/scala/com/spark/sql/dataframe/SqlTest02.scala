package com.spark.sql.dataframe

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SparkSession}

object SqlTest02 {

  def main(args: Array[String]): Unit = {
    //TODO 准备环境
    val conf = new SparkConf().setMaster("local[*]").setAppName("operator")
    val spark = SparkSession.builder().config(conf).getOrCreate()

    val df:DataFrame = spark.read.json("hadoop/datas/user.json")

    df.createOrReplaceTempView("user")
    spark.udf.register("prefix",(name:String)=>{"userName:"+name})
    spark.sql("select age,prefix(name) from user").show()

    spark.stop()
  }

  case class User(age:Int,name:String);

}
