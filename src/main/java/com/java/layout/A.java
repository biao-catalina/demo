package com.java.layout;

import com.java.SyncThread;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class A {

    private SyncThread syncThread;

    private String name;

    String[] arr;


    public static void main(String[] args) throws InterruptedException {

        System.out.println(ClassLayout.parseClass(A.class).toPrintable());



    }

    private static void compareTime() {
        /*        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        A a = new A();
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            a.add();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }

    private static void printObjectHeader() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        A a = new A();
        a.hashCode();
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseInstance(a).toPrintable());

    }

    private int i;

    private synchronized void add() {
        i++;
    }
}
