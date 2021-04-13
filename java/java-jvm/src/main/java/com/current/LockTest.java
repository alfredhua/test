package com.current;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by guozhenhua
 * date 2020/5/12.
 */
public class LockTest {

    public static void main(String[] args) {
        ReentrantLock reentrantLock=new ReentrantLock();
        reentrantLock.lock();

        reentrantLock.unlock();


        ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
        readWriteLock.readLock().lock();
        readWriteLock.readLock().unlock();

        readWriteLock.writeLock().lock();
        readWriteLock.writeLock().unlock();
        synchronized(LockTest.class){
            System.out.println("--------");
        }

    }
}
