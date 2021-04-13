package com.current.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest {

    static ExecutorService thread= Executors.newFixedThreadPool(8);

    public static void main(String[] args) {

        for (int i=0;i<1000000;i++) {
//            thread.execute(() -> {
//                StringBuilder a=new StringBuilder("aaaaaaaa");
//                Counter.set(a.append("bbbbb").toString());
//
//            });
//
            new Thread(()->{
                StringBuilder a=new StringBuilder("aaaaaaaa");
                Counter.set(a.append("bbbbb").toString());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //threadLocal.remove();
            }).start();
        }
    }



}
