package com.current.threadlocal;

public class Counter {

    public static ThreadLocal<StringBuilder> counter = ThreadLocal.withInitial(() -> new StringBuilder());


    public static void add(String newStr) {
        StringBuilder str = counter.get();
        counter.set(str.append(newStr));
    }


    public static void print() {
        System.out.printf("Thread name:%s , ThreadLocal hashcode:%s, Instance hashcode:%s, Value:%s\n",
                Thread.currentThread().getName(),
                counter.hashCode(),
                counter.get().hashCode(),
                counter.get().toString());
    }


    public static void set(String words) {
        counter.set(new StringBuilder(words));
        System.out.printf("Set, Thread name:%s , ThreadLocal hashcode:%s,  Instance hashcode:%s, Value:%s\n",
                Thread.currentThread().getName(),
                counter.hashCode(),
                counter.get().hashCode(),
                counter.get().toString());
    }


}
