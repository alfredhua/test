package com.current;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {


    static class Car extends Thread{
      private int num;
      private Semaphore semaphore;

      public Car(int num, Semaphore semaphore) {
        this.num = num;
        this.semaphore = semaphore;
      }

      @Override
      public void run() {
        try {
          semaphore.acquire();

          System.out.println("第"+num+"抢走一个车位");
          Thread.sleep(2000);
          System.out.println("第"+num+"开走了");
          semaphore.release();

        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }

  public static void main(String[] args) {
    Semaphore semaphore=new Semaphore(5);

    for (int i = 0; i <10; i++) {
      new Car(i,semaphore).start();
    }

  }

}
