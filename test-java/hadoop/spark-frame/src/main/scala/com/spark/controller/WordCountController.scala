package com.spark.controller

import com.spark.common.TController
import com.spark.service.WordCountService

class WordCountController extends TController{

  override def dispatch(): Unit = {
    new WordCountService().dataAnalysis()
  }

}
