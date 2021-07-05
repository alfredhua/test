package com.spark.utils

import org.apache.spark.SparkContext

object EnvUtil {

  val scLocal =new ThreadLocal[SparkContext];


  def put(sc: SparkContext): Unit ={
    scLocal.set(sc)
  }

  def get(): SparkContext ={
    scLocal.get()
  }

  def clear(): Unit ={
    scLocal.remove()
  }

}
