package com.algorithm.math;

import java.util.Scanner;

/**
 * 最大公约数
 */
public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int x = sca.nextInt();
        int y = sca.nextInt();
        if (x <= 0 || y <= 0 || x == y) {
            System.out.println("null");
        }
        for (; ; ) {
            int min = Math.min(x, y);
            x = Math.max(x, y) % Math.min(x, y);
            y = min;
            if (x == 0) {
                System.out.println(y);
                break;
            }
        }

        
    }
}
