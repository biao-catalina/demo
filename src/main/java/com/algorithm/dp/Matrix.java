package com.algorithm.dp;

import java.util.Scanner;

public class Matrix {

    public void modifyWords() {
        String s1 = "ab12cd3";
        String s2 = "abcdf";
        int ic = 5;
        int dc = 3;
        int rc = 2;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (i == 1 || j == 1) {
                        if (i < j) dp[i][j] = dp[i][j - 1] + ic;
                        else if (i > j) dp[i][j] = dp[i - 1][j] + dc;
                    } else{
                        dp[i][j] = Math.min(dp[i - 1][j - 1] + rc, Math.min(dp[i][j - 1] + ic, dp[i - 1][j] + dc));
                    }
                }
            }
        }
        System.out.println(dp[s1.length()][s2.length()]);
    }

    public void shortestPath() {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[][] m = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                m[i][j] = scanner.nextInt();
            }
        }
        int[][] dp = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == 0 && j == 0) dp[i][j] = m[i][j];
                else if (i == 0) dp[i][j] = m[i][j] + dp[i][j - 1];
                else if (j == 0) dp[i][j] = m[i][j] + dp[i - 1][j];
                else
                    dp[i][j] = m[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);

            }
        }
        System.out.println(dp[x - 1][y - 1]);
    }

    public void longestIncrementNumber() {
        int[] arr = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {

        }
    }

    public void longestCommonLetter() {
        String s1 = "1a2c3d4b56";
        String s2 = "b1d23ca45b6a";
        int max = 0;

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int m = 1;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        System.out.print(s1.charAt(i - 1));
                    }
                    m++;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println();
/*        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                System.out.print(dp[i + 1][j + 1] +" ");
            }
            System.out.println();
        }*/
        System.out.println(dp[s1.length()][s2.length()]);
    }

    public static void main(String[] args) {
        Matrix matrix = new Matrix();
//        matrix.longestCommonLetter();
        //        matrix.shortestPath();
        matrix.modifyWords();
    }
}
