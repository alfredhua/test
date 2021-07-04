package com.spark.core

import java.io.ObjectInputStream
import java.net.ServerSocket

object Executor{


  def main(args: Array[String]): Unit = {

    val server=new ServerSocket(9999)

    println("server 服务器启动，等待接收数据")

    val socket = server.accept()

    val in = socket.getInputStream

    val objIn = new ObjectInputStream(in)


    val task:SubTask = objIn.readObject().asInstanceOf[SubTask]

    val datas = task.compute()

    println("计算结果为："+datas.toString())

    objIn.close()
    socket.close()
    server.close()

  }


}
