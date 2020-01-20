package com.example.proxy;

import com.example.service.GreetService;
import com.example.service.impl.GreetServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class GreetServiceProxy implements InvocationHandler {
    public static void main(String[] args) {
        GreetService greetService = (GreetService) Proxy.newProxyInstance(GreetService.class.getClassLoader(),
                new Class[]{GreetService.class}, new GreetServiceProxy(new GreetServiceImpl()));
        greetService.sayHi();
//        System.out.println(greetService);
    }
    private GreetService greetService;

    public GreetServiceProxy(GreetService greetService) {
        this.greetService = greetService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before proxy");
        method.invoke(greetService, args);
        System.out.println("after proxy");
        return null;
    }
}
