package com.current;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {

  public static void main(String[] args) {
//    testExecutor();
     before();
  }

  private static void testExecutor(){
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    executorService.execute(()-> System.out.println("------------"));
    executorService.shutdown();
  }

  private static void before() {
    ExecutorTest es = new ExecutorTest(5, 5, 0L,
        TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
    es.execute(()-> System.out.println("------------"));
    es.shutdown();
  }

}
