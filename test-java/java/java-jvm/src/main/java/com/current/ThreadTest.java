package com.current;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by guozhenhua
 * date 2020/5/25.
 */
public class ThreadTest {

    private boolean flag=true;

    public static void main(String[] args) throws InterruptedException {

        Executors.newFixedThreadPool(10);
        ThreadTest app=new ThreadTest();

        Thread aaaaa = new Thread(() -> {
            app.change();
            System.out.println("aaaaa");
        });

        new Thread(()->{
            app.foreach();
            System.out.println("bbbbbb");
        }).start();

        Thread.sleep(1000);
        aaaaa.start();
    }

    public void change(){
        flag=false;
    }


    public void foreach(){

        while (flag){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
