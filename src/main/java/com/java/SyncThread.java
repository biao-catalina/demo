package com.java;

import com.example.DemoApplication;

import java.util.HashMap;

public class SyncThread {

    public static synchronized void a(){
        System.out.println("aaa" +Thread.currentThread().getId());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void b() {
        System.out.println("bbb");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        int hashCode = new DemoApplication().hashCode();
        String binaryString = Integer.toBinaryString(hashCode);
        System.out.println(hashCode);
        System.out.println(binaryString);
        System.out.println(binaryString.length());


    }

    public static void  threadInterrupt() {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().isInterrupted());
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }
}
