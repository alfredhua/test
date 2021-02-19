package com.current;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ConditionNotify implements Runnable {

  private Lock lock;

  private Condition condition;

  public ConditionNotify(Lock lock, Condition condition) {
    this.lock = lock;
    this.condition = condition;
  }

  @Override
  public void run() {
    lock.lock();

    try {
      System.out.println("begin ConditionNotify");

      condition.signal();//唤醒阻塞状态的线程

      condition.await();

      System.out.println("end ConditionNotify");

    } catch (Exception e) {
      e.printStackTrace();
    }

    lock.unlock();

  }

}
