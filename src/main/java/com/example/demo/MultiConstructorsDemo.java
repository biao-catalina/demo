package com.example.demo;

import java.util.Arrays;

public class MultiConstructorsDemo {

    private String name;
    private String age;

    public MultiConstructorsDemo() {
    }

    public MultiConstructorsDemo(String name) {
        this.name = name;
    }

    public MultiConstructorsDemo(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        char c = '，';
        System.out.println(Integer.toHexString(c));
        System.out.println(Arrays.toString(MultiConstructorsDemo.class.getDeclaredConstructors()));
    }
}
