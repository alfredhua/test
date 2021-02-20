package com.current;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionApp {

  public static void main(String[] args) {
    Lock lock=new ReentrantLock();

    Condition condition = lock.newCondition();

    new Thread(new ConditionWait(lock,condition)).start();
    new Thread(new ConditionNotify(lock,condition)).start();

    ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap();

    concurrentHashMap.put("a","b");

  }
}
