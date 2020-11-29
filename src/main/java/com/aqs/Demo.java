package com.aqs;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class Demo {
    public static void main(String[] args) {

        StampedLock stampedLock = new StampedLock();
        long l = stampedLock.tryReadLock();


        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        lock.readLock().lock();

        new Thread(() -> {
            lock.readLock().lock();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            lock.writeLock().unlock();
        }).start();


    }
}
