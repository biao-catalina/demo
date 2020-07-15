package com.algorithm.math;


/**
 * 斐波那契数列
 * 0 1 1 2
 */
public class Fib {

    public static void main(String[] args) {
        Fib f = new Fib();
        long s1 = System.currentTimeMillis();
//        System.out.println(f.fib(46));
        long s2 = System.currentTimeMillis();
        System.out.println(f.fibDynamic(400));
        long s3 = System.currentTimeMillis();
        System.out.println(f.fibWithTemp(400));

        long s4 = System.currentTimeMillis();

        System.out.println(s2 - s1);
        System.out.println(s3 - s2);
        System.out.println(s4 - s3);
    }

    public int fibWithTemp(int n) {
        int a = 0;
        int b = 1;

        if (n <= 2) return n - 1;
        for (int i = 3 ; i < n; i++) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return a + b;
    }

    public int fibDynamic(int n) {

        if (n <= 2) return n - 1;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < 2) arr[i] = i;
            else
                arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n - 1];
    }

    public int fib(int n) {
        if (n <= 2) return n - 1;
        return fib(n - 1) + fib(n - 2);
    }

}
