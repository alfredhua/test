package com.current;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo  extends Thread {

    public static void main(String[] args) {

      CountDownLatch countDownLatch=new CountDownLatch(3);

      new Thread(()->{
        try {
          System.out.println("---------子线程"+Thread.currentThread().getName()+"正在执行");
          Thread.sleep(3000);
          System.out.println("----over-------子线程"+Thread.currentThread().getName()+"执行完毕");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        countDownLatch.countDown();
      }).start();

      new Thread(()->{
        try {
          System.out.println("---------子线程"+Thread.currentThread().getName()+"正在执行");
          Thread.sleep(3000);
          System.out.println("----over-------子线程"+Thread.currentThread().getName()+"执行完毕");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        countDownLatch.countDown();
      }).start();

      new Thread(()->{
        try {
          System.out.println("---------子线程"+Thread.currentThread().getName()+"正在执行");
          Thread.sleep(3000);
          System.out.println("----over-------子线程"+Thread.currentThread().getName()+"执行完毕");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        countDownLatch.countDown();
      }).start();

      try {
        System.out.println("等待3个子线程执行完毕...");
        countDownLatch.await();
        System.out.println("3个子线程已经执行完毕");
        System.out.println("继续执行主线程");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
   }



//  static CountDownLatch countDownLatch=new CountDownLatch(100);
//
//
//  public static void main(String[] args) throws InterruptedException {
//    for (int i = 0; i < 100; i++) {
//      new CountDownLatchDemo().start();
//      countDownLatch.countDown();
//    }
//  }
//
//  @Override
//  public void run() {
//    try {
//      countDownLatch.await();
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//    System.out.println("ThreadName:"+Thread.currentThread().getName());
//  }






}
