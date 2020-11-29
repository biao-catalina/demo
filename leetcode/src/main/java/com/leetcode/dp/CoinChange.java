package com.leetcode.dp;

import java.io.File;
import java.io.IOException;

public class CoinChange {
    public static void main(String[] args) {
        File f = new File("D:\\context.txt");
        try {
            System.out.println(f.getCanonicalPath());
            System.out.println(f.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] coins = {1, 2147483647};
        int amount = 2;
        CoinChange c = new CoinChange();
        System.out.println(c.coinChange(coins, amount));
    }


    public int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        int[] arr = new int[amount + 1];
        for (int coin : coins) {
            if (coin <= amount) {
                arr[coin] = 1;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > 0) {
                for (int coin : coins) {
                    if (i + ((long) coin) <= amount) {
                        if (arr[i + coin] == 0) {
                            arr[i + coin] = arr[i] + 1;
                        } else {
                            arr[i + coin] = Math.min(arr[i + coin], arr[i] + 1);
                        }
                    }
                }
            }
        }
        return arr[amount] > 0 ? arr[amount] : -1;
    }
}
