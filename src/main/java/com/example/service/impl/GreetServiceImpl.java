package com.example.service.impl;

import com.example.service.GreetService;

import java.lang.reflect.Method;

public class GreetServiceImpl implements GreetService {
    @Override
    public void sayHi() {
        System.out.println("hi");
        sayWelcome();
    }

    @Override
    public void sayWelcome() {
        System.out.println("welcome");
    }

    public static void main(String[] args) {
        Method[] methods = GreetServiceImpl.class.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + "---" + method.getDeclaringClass());
        }

     /*   GreetService g = new GreetServiceImpl();
        g.sayHi();*/
    }


}
