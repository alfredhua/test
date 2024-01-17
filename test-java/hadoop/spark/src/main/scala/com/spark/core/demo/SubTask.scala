package com.spark.core.demo

class SubTask extends Serializable {

  var datas :List[Int]= _

//  var logic=( num:Int)=>{ num * 2 }

  var logic :Int => Int = _

  def  compute()={
    datas.map(logic)
  }

}
