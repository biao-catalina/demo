package com.biao.netty;

public abstract class AbstractDemo {

    protected String string;

    protected AbstractDemo() {
        System.out.println("hello");
        string = "concrete";
    }
}
