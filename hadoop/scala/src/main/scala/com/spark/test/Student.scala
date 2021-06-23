package com.spark.test

class Student (name:String,age :Int){

  def  printInfo(): Unit ={
    print(name+"======"+age+"====="+Student.school)
  }
}


object Student{
  var school:String="aaaa"

  def main(args: Array[String]): Unit = {
    new Student("a",10).printInfo()
  }

}