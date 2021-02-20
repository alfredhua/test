package com.current;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ConditionWait implements Runnable {

  private Lock lock;

  private Condition condition;

  public ConditionWait(Lock lock, Condition condition) {
    this.lock = lock;
    this.condition = condition;
  }

  @Override
  public void run() {
    lock.lock();

    try {
      System.out.println("begin conditionwait");
      condition.await();
      System.out.println("end conditionwait");

      condition.signal();

    } catch (Exception e) {
      e.printStackTrace();
    }

    lock.unlock();

  }
}
