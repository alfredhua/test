package com.spring.formework2.core;

import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FactoryBean {

    public static void main(String[] args) {
        TreeMap<String,String> map=new TreeMap<String, String>();
        map.put("a", "a");
        map.put("a", "b");
        System.out.println(map.size());

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.HOURS, new ArrayBlockingQueue<>(100));

        threadPoolExecutor.shutdown();
    }
}
