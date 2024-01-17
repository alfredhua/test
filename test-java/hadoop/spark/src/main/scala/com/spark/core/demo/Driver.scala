package com.spark.core.demo

import java.io.ObjectOutputStream
import java.net.Socket

object Driver {


  def main(args: Array[String]): Unit = {

    val socket1 = new Socket("localhost", 9999)

    val socket2 = new Socket("localhost", 8888)


    val out = socket1.getOutputStream

    val outObj1 = new ObjectOutputStream(out)
    val task = new Task()

    val subTask: SubTask = new SubTask()

    subTask.logic = task.logic
    subTask.datas = task.datas.take(2)
    outObj1.writeObject(subTask)
    outObj1.flush()
    outObj1.close()
    socket1.close()


    val outObj2 = new ObjectOutputStream(out)
    val subTask2: SubTask = new SubTask()
    subTask2.logic = task.logic
    subTask2.datas = task.datas.takeRight(2)
    outObj2.writeObject(subTask2)
    outObj2.flush()
    outObj2.close()
    socket2.close()

  }

}
