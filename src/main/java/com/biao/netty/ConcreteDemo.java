package com.biao.netty;

import java.lang.reflect.Field;

public class ConcreteDemo extends AbstractDemo {
    private ConcreteDemo() {
    }

    public String name;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ConcreteDemo concreteDemo = new ConcreteDemo();
        System.out.println(concreteDemo.string);
        concreteDemo.name = "trump";

        Field name = ConcreteDemo.class.getDeclaredField("name");
        System.out.println(name.get(concreteDemo));
        name.set(new ConcreteDemo(), "Xi");
        System.out.println(name.get(concreteDemo));
    }
}
