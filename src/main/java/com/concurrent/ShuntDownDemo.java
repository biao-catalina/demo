package com.concurrent;

import java.util.ArrayList;
import java.util.List;

public class ShuntDownDemo {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        new Thread(() -> {
            do {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.add(1);
                System.out.println(list.size());

            } while (list.size() <= 10);
        }).start();


        new Thread(() -> {
            while (true) {
                new ShuntDownDemo().hashCode();
//                System.out.println(list.size());
                if (list.size() == 5) {
                    break;
                }
            }
            System.out.println("---------------------");

        }).start();
    }
}
