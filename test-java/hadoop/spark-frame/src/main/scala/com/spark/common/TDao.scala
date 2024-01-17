package com.spark.common

import com.spark.utils.EnvUtil


trait TDao {

    def readFile(path:String) = {
        EnvUtil.get().textFile(path)
    }
}
