package com.java.thread;

public class Poller implements Runnable {
    @Override
    public void run() {

        System.out.println(111);
    }


    public static void main(String[] args) {
        Thread t = new Thread(new Poller(), "fds");
        t.start();
    }
}
