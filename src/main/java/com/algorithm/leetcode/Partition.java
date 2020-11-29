package com.algorithm.leetcode;

import java.util.stream.IntStream;

public class Partition {
    public static void main(String[] args) {
        Partition p = new Partition();
        System.out.println(p.canPartition(new int[]{1, 5, 2, 4}));
    }
    public boolean canPartition(int[] nums) {

        int sum  = IntStream.of(nums).sum();
        int half = (sum >> 1);
        if ((sum & 1) == 1) return false;

        // We need the first true element.
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;

        for (int n: nums){
            // The same coin can only be used once,
            // so need to traversal in reverse order.
            for (int i = half; i >= 1; i--){
                // If bag has rest.
                if (i - n >= 0) {
                    dp[i] |= dp[i - n];
                }
            }
        }

        return dp[half];
    }
}
