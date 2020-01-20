package com.example.proxy;

import com.example.service.GreetService;
import com.example.service.impl.GreetServiceImpl;
import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;

public class GreetServiceCglibProxy implements MethodInterceptor {


    public static void main(String[] args) {
        //将sam,class文件写到硬盘
        //通过生成子类的方式创建代理类
        GreetService greetService = (GreetService) getProxyInstance(new GreetServiceImpl());
        greetService.sayHi();
        System.out.println(greetService.hashCode());
        System.out.println(new GreetServiceImpl().hashCode());
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("pre" + methodProxy.getSuperName());
        //通过代理类调用父类中的方法,即实体类方法
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("after" + methodProxy.getSuperName());
        return result;
    }

    public static Object getProxyInstance(Object realSubject) {
        Enhancer enhancer = new Enhancer();
        //需要创建子类的类,即定义委托类
        enhancer.setSuperclass(realSubject.getClass());
        //设置两个CallBack以及CallbackFilter
        Callback[] callbacks = new Callback[2];
        callbacks[0] = new GreetServiceCglibProxy();
        callbacks[1] = new CglibProxy2();
        enhancer.setCallbacks(callbacks);
        enhancer.setCallbackFilter(new Filter());

        //通过字节码技术动态创建子类实例
        return enhancer.create();
    }

    static class Filter implements CallbackFilter {
        @Override
        public int accept(Method method) {
            if (method.getDeclaringClass() != Object.class) {
                return 0;
            }
            return 1;
        }
    }

    static class CglibProxy2 implements MethodInterceptor {

        //实现MethodInterceptor接口，定义方法的拦截器
        @Override
        public Object intercept(Object o, Method method, Object[] objects,
                                MethodProxy methodProxy) throws Throwable {
/*            System.out.println("pre1");
            //通过代理类调用父类中的方法,即实体类方法
            Object result = methodProxy.invokeSuper(o, objects);
            System.out.println("after1");
            return result;*/
            return null;
        }
    }
}
