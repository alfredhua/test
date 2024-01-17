package com.current;

import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedTest {

  public static void main(String[] args) {
    synchronized(SynchronizedTest.class){
      System.out.println("pppppp");
      final AtomicInteger atomicInteger = new AtomicInteger();
      final int i = atomicInteger.addAndGet(10);
      System.out.println(i);
      final int andSet = atomicInteger.getAndSet(12);
      System.out.println(andSet);
      final int i1 = atomicInteger.get();
      System.out.println(i1);

      LinkedHashMap linkedHashMap=new LinkedHashMap();

      linkedHashMap.put("","");

    }
  }

}
