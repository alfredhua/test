package com.spark.test

object Func {

  def two(fun:(Int,Int)=>Int):Int={
    fun(1,2)
  }

  def main(args: Array[String]): Unit = {
    val fun=(a:Int,b:String,c:Char)=>{
       if (a==0 && b=="" && c==0) return false else return true
    }


    def func2(a:Int):String=>( Char => Boolean) ={
      //      def f1(s:String):Char => Boolean ={
      //          def f2(c:Char):Boolean={
      //            false
      //          }
      //          f2
      //      }
      //      f1 _
      s => c => if (a==0 && s=="" && c==0)  false else  true
    }

    def func3(a:Int)(b:String)(c:Char):Boolean={
       a==0 && b=="" && c==0
    }

  }




  def  twoOp(op:(Int,Int)=>Int,a:Int,b:Int):Int ={


    op(a,b)
  }




}
