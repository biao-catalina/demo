package com.algorithm.dp;

/**
 * @author admin
 * @dateTime 2020-01-19 09:21:00
 */
public class DpDemo {
    public static void main(String[] args) {

        int[] weight = {4, 2, 1};
        int[] value = {12, 10, 6};

        int n = 3;
        int w = 5;

        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            for (int cw = 1; cw <= w; cw++) {
                if (weight[i - 1] <= cw) {
                    dp[i][cw] = Math.max(
                            dp[i-1][cw], // 不加新的物品
                            value[i-1] + dp[i-1][cw-weight[i-1]] //增加新物品
                    );
                } else {
                    dp[i][cw] = dp[i - 1][cw];
                }
            }
        }

        System.out.println(dp[n][w]);
        for (int i = 0; i <= n; i++) {
            for (int cw = 0; cw <= w; cw++) {
                System.out.print(dp[i][cw]+" ");
            }
            System.out.println();
        }

    }
}
