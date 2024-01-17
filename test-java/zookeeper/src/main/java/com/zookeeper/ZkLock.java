package com.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * Created by guozhenhua
 * date 2020/5/19.
 */
public class ZkLock {
    private static String CONNECTION_STR="127.0.0.1:2181";

    public static void main(String[] args) {
        CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder();
        CuratorFramework curatorFramework = builder.connectString(CONNECTION_STR).sessionTimeoutMs(5000)
                .retryPolicy(new ExponentialBackoffRetry(100, 3))
                .build();
        curatorFramework.start();
        try {
            final InterProcessMutex lock=new InterProcessMutex(curatorFramework ,"/locks3");

            for(int i=0;i<10;i++){
                new Thread(()->{
                    System.out.println(Thread.currentThread().getName()+"->尝试获取锁");
                    try {
                        lock.acquire();
                        System.out.println(Thread.currentThread().getName()+"->获得锁成功");
                    } catch (Exception e){
                        e.printStackTrace();
                    }

                    try {
                        Thread.sleep(4000);
                        lock.release();
                        System.out.println(Thread.currentThread().getName()+"->释放锁成功");
                    } catch (Exception e){
                        e.printStackTrace();
                    }

                },"t"+i).start();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
