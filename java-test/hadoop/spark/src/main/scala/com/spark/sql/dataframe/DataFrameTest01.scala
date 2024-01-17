package com.spark.sql.dataframe

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SparkSession}

object DataFrameTest01 {

  def main(args: Array[String]): Unit = {
    //TODO 准备环境
    val conf = new SparkConf().setMaster("local[*]").setAppName("operator")
    val sc = SparkSession.builder().config(conf).getOrCreate()
    import sc.implicits._

    val df:DataFrame = sc.read.json("hadoop/datas/user.json")
//    frame.show()

    // df ===> SQL
//    df.createOrReplaceTempView("user")
//    val frame1 = sc.sql("select  * from user order by age desc")
//    frame1.show()

    //df ==> DSL
//    df.select("age","name").show()
//    df.select('age+1).show()

    val seq=Seq(1,2,3,4)
    val value = seq.toDS()
    value.show()

    sc.stop()
  }

  case class User(age:Int,name:String);

}
