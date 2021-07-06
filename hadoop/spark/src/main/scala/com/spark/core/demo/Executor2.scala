package com.spark.core.demo

import java.io.ObjectInputStream
import java.net.ServerSocket

object Executor2 {


  def main(args: Array[String]): Unit = {

    val server = new ServerSocket(8888)

    println("server 服务器启动，等待接收数据")

    val socket = server.accept()

    val in = socket.getInputStream

    val objIn = new ObjectInputStream(in)

    val task: SubTask = objIn.readObject().asInstanceOf[SubTask]

    val datas = task.compute()

    println("计算结果为：" + datas.toString())

    objIn.close()
    socket.close()
    server.close()

  }


}
