package com.algorithm.dp;

//动态规划
public class Dp {
    public static void main(String[] args) {
        int[] weight = {10, 20, 40};
        int[] value = {60, 100, 120};
        int n = 3;
        int w = 50;

        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            for (int cw = 1; cw <= w; cw++) {
                if (weight[i - 1] <= cw) {
                    dp[i][cw] = Math.max(
                            value[i - 1] + dp[i - 1][cw - weight[i - 1]]
                            , dp[i - 1][cw]
                    );
                } else {
                    dp[i][cw] = dp[i - 1][cw];
                }
            }
        }
        System.out.println("max value is " + dp[n][w]);
    }
}
