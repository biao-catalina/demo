package com.java.aqs;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReRWLockExample {
    private Object data = null;
    /* 创建一个读写锁 */
    ReadWriteLock rwlock = new ReentrantReadWriteLock();

    /**
     * 读数据，可以多个线程同时读， 所以上读锁即可
     */
    public void get() {
        /* 上读锁 */
        rwlock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + " 准备读数据!");
            /* 休眠 */
            Thread.sleep((long) (Math.random() * 1000));
            System.out.println(Thread.currentThread().getName() + "读出的数据为 :" + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwlock.readLock().unlock();
        }

    }


    public void put(Object data) {

        /* 上写锁 */
        rwlock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + " 准备写数据!");
            /* 休眠 */
            Thread.sleep((long) (Math.random() * 1000));
            this.data = data;
            System.out.println(Thread.currentThread().getName() + " 写入的数据: " + data);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwlock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {

        /* 创建ReadWrite对象 */
        final ReRWLockExample readWrite = new ReRWLockExample();

        /* 创建并启动3个读线程 */
        for (int i = 0; i < 3; i++) {
            new Thread(readWrite::get).start();

            /*创建3个写线程*/
            new Thread(() -> {
                /*随机写入一个数*/
                readWrite.put(new Random().nextInt(8));

            }).start();
        }

    }


}
