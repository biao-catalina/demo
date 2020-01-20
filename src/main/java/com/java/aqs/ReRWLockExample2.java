package com.java.aqs;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReRWLockExample2 {

    public static void main(String[] args) {
        ReadWriteLock rwlock = new ReentrantReadWriteLock();
        rwlock.readLock().lock();
        rwlock.writeLock().lock();
        System.out.println(111);
    }


}
