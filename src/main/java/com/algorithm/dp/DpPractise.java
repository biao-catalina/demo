package com.algorithm.dp;

public class DpPractise {

    public static void main(String[] args) {
        DpPractise dpPractise = new DpPractise();

/*        int[][] arr = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(dpPractise.minPathSum(arr));*/

        int[] coins = { 2, 5};
        int amount = 12;
        System.out.println(dpPractise.coinChange(coins, amount));

    }


    public int coinChange(int[] coins, int amount) {

        if (amount == 0)
            return 0;

        //memo[n] represents the minimum number of coins needed to reach n
        int[] memo = new int[amount + 1];

        for (int i = 0; i < coins.length; i++) {
            //annoying edge case
            if (coins[i] == Integer.MAX_VALUE)
                coins[i] = 0;

            //bounds checking, ignore coins above amount
            //would remove them from the array entirely, but test cases aren't large enough for it to matter
            if (coins[i] <= amount)
                //can reach n with 1 coin if there is a coin of value n
                memo[coins[i]] = 1;

        }

        for (int i = 0; i < amount; i++) {
            if (memo[i] == 0) continue; //unreachable value
            for (int coin : coins) {
                //add each coin to this value
                int value = i + coin;

                if (value <= amount) {//ignoring calculations that go over + bounds checking
                    if (memo[value] == 0)//this new value is reachable by adding a coin
                        memo[value] = memo[i] + 1;
                    else//old value, but see if it's faster with this sequence of coins
                        memo[value] = Math.min(memo[value], memo[i] + 1);
                }
            }
        }
        return memo[amount] == 0 ? -1 : memo[amount];
    }

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
