package com.java.aqs;

import java.util.concurrent.locks.ReentrantLock;

public class ReLockExample {

    public static void main(String[] args) {

        ReentrantLock reentrantLock = new ReentrantLock(true);

        reentrantLock.lock();

//        reentrantLock.unlock();

        Thread t1 = new Thread(() -> {
            reentrantLock.lock();
            System.out.println(1);
        });

        t1.start();

        try {
           Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        reentrantLock.unlock();



    }
}
