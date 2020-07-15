package com.java;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

public class MapDemo {


    public static void main(String[] args) {
        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();
        map.put("hello", "world");



        System.out.println(Integer.toBinaryString(-1));


    }





    static class Target{
        public int value = 10;
    }

    public void demo() throws NoSuchFieldException, IllegalAccessException {
        System.out.println(MapDemo.class.getResource("/").getPath());

        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);

        //获得Target实例域value
        Field valueField = Target.class.getDeclaredField("value");
        //实例化Target
        Target t = new Target();
        System.out.println("原始value值:" + valueField.get(t));

        //获得实例域在class文件里的偏移量
        final long valueOffset = unsafe.objectFieldOffset(valueField);

        //第一次swap
        System.out.println("第一次swap(10,20)函数返回值:" + unsafe.compareAndSwapInt(t, valueOffset, 10, 20));
        System.out.println("第一次swap(10,20)后value值:" + valueField.get(t));

        //第二次swap
        System.out.println("第一次swap(10,20)函数返回值:" + unsafe.compareAndSwapInt(t, valueOffset, 20, 20));
        System.out.println("第一次swap(10,20)后value值:" + valueField.get(t));


        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();

        new Thread(() -> {
            map.put("hello", "world");
        }).start();
        new Thread(() -> {
            map.put("hello", "world");
        }).start();
    }


}


