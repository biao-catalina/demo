package com.algorithm.peking;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 青蛙的约会
 * http://poj.org/problem?id=1061
 */
public class DateOfFrog {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt(); // 青蛙A位置
        int y = scanner.nextInt(); // 青蛙B位置
        int m = scanner.nextInt(); // 青蛙A步长
        int n = scanner.nextInt(); // 青蛙B步长
        int l = scanner.nextInt(); // 总长

        if (x < 0 || y < 0 || m <= 0 || m >= l || n >= l || x == y) {
            return;
        }
        Set<String> set = new HashSet<>();
        for (int i=1; ; i++) {
            if (x + m > l) {
                x = x + m - l;
            } else {
                x = x + m;
            }
            if (y + n > l) {
                y = y + n - l;
            } else {
                y = y + n;
            }
            if (x == y) {
                System.out.println("需要步数: " + i);
                break;
            }
            if (set.contains(x + "-" + y)) {
                System.out.println("impossible");
                break;
            }
            set.add(x + "-" + y);
        }
    }

}
