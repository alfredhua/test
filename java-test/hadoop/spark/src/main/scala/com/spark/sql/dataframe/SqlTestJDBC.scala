package com.spark.sql.dataframe

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession}

object SqlTestJDBC {

  def main(args: Array[String]): Unit = {
    //TODO 准备环境
    val conf = new SparkConf().setMaster("local[*]").setAppName("operator")
    val spark = SparkSession.builder().config(conf).getOrCreate()

    val df = spark.read.format("jdbc")
      .option("url", "jdbc:mysql://127.0.0.1:3306/demo?useSSL=false")
      .option("driver", "com.mysql.cj.jdbc.Driver")
      .option("user", "root")
      .option("password", "root")
      .option("dbtable", "user")
      .load()
    df.show()

    df.write.format("jdbc")
      .option("url","jdbc:mysql://127.0.0.1:3306/demo?useSSL=false")
      .option("driver","com.mysql.cj.jdbc.Driver")
      .option("user","root")
      .option("password","root")
      .option("dbtable","user2").mode(SaveMode.Append).save()

    spark.stop()
  }

  case class User(age:Int,name:String);

}
