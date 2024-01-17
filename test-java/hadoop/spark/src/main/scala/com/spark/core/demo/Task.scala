package com.spark.core.demo

class Task extends Serializable {

  var datas=List(1,2,3,4)

  var logic=( num:Int)=>{ num * 2 }

//  var logic :Int => Int = _ * 2

  def  compute()={
     datas.map(logic)
  }

}
