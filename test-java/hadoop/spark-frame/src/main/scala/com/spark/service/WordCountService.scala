package com.spark.service

import com.spark.common.TService
import com.spark.dao.WordCountDao

class WordCountService extends TService{

  override def dataAnalysis(): Any = {
    val lines = new WordCountDao().readFile("")
    lines.flatMap(_.split(" "))
      .map(word=>(word,1))
      .reduceByKey(_+_)
      .collect()
  }

}
