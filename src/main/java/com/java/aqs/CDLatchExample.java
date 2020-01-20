package com.java.aqs;

import java.util.concurrent.CountDownLatch;

public class CDLatchExample {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        try {
            countDownLatch.await();
            System.out.println(111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
