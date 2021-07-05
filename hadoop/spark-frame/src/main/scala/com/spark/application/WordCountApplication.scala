package com.spark.application

import com.spark.common.TApplication
import com.spark.controller.WordCountController

object WordCountApplication extends App  with TApplication{


  start(){
    new WordCountController().dispatch()
  }

}
