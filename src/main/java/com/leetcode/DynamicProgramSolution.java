package com.leetcode;

public class DynamicProgramSolution {

    public static void main(String[] args) {
        DynamicProgramSolution s = new DynamicProgramSolution();
        System.out.println(s.integerBreak(100));
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        if (n < 2) return 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (dp[i - j]), j * (i - j)));
//                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i-j,dp[i-j]));
            }
        }

        return dp[n];
    }
}
