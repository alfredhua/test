package com.current;

import java.util.concurrent.CountDownLatch;

public class CurrentDownLatchDemo3 {

    public static void main(String[] args) {
        CountDownLatch countDownLatch=new CountDownLatch(3);
        new Thread(()->{
            try {
                System.out.println("----over-------子线程"+Thread.currentThread().getName()+"执行完毕");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
        new Thread(()->{
            countDownLatch.countDown();
            try {
                System.out.println("----over-------子线程"+Thread.currentThread().getName()+"执行完毕");
                Thread.sleep(3000);
                System.out.println("---------子线程"+Thread.currentThread().getName()+"正在执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                System.out.println("----over-------子线程"+Thread.currentThread().getName()+"执行完毕");
                Thread.sleep(3000);
                System.out.println("---------子线程"+Thread.currentThread().getName()+"正在执行");
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
}
