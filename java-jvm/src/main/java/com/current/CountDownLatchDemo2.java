package com.current;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo2 extends Thread {

  public static void main(String[] args) {
    CountDownLatch countDownLatch=new CountDownLatch(100);
    for (int i = 0; i < 100; i++) {
      new CountDownLatchDemo2().start();
      countDownLatch.countDown();
    }
  }

  @Override
  public void run() {
    try {
      System.out.println("---------子线程"+Thread.currentThread().getName()+"正在执行");
      Thread.sleep(3000);
      System.out.println("----over-------子线程"+Thread.currentThread().getName()+"执行完毕");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
