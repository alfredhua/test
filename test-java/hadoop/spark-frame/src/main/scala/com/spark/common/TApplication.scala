package com.spark.common

import com.spark.utils.EnvUtil
import org.apache.spark.{SparkConf, SparkContext}

trait TApplication {

    def start(master:String="local[*]",appName:String="application")(op: => Unit) :Unit={
        val sparkConf = new SparkConf().setMaster(master).setAppName(appName)
        val sc = new SparkContext(sparkConf)
        EnvUtil.put(sc)
        try{
            op
        }catch{
            case ex =>{ println(ex.getMessage)}
        }
        sc.stop()
        EnvUtil.clear()


    }


}
