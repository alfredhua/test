package com.current;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorTest2 extends Thread {

   int a,b;

  public ExecutorTest2(int a,int b){
    this.a=a;
    this.b=b;
  }

  @Override
  public void run() {
    double re=a/b;
    System.out.println(re);
  }

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ThreadPoolExecutor pools=new ThreadPoolExecutor(0, Integer.MAX_VALUE,
        0L, TimeUnit.SECONDS,new SynchronousQueue<>());
    for(int i=0;i<5;i++){
      pools.execute(new ExecutorTest2(100,i));
    }
    pools.shutdown();
  }

}
