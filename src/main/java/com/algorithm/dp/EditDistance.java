package com.algorithm.dp;

public class EditDistance {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "dac";
        System.out.println(deleteOperation(str1, str2));
    }

    public static int deleteOperation(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= s2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                int temp;
                if (i == 1 && j == 1) {
                    temp = 1;
                } else {
                    temp = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
                if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
                    temp += 1;
                }
                dp[i][j] = temp;
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static int editDistance(String str1, String str2) {
        int[][] dp = new int[str1.length()][str2.length()];
        if (str1.length() == 0 || str2.length() == 0) {
            return Math.max(str1.length(), str2.length());
        }
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                int temp;
                if (i == 0 && j == 0) {
                    temp = 0;
                } else if (i == 0) {
                    temp = dp[i][j - 1];
                } else if (j == 0) {
                    temp = dp[i - 1][j];
                } else {
                    temp = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }
                if (str1.charAt(i) != str2.charAt(j)) {
                    temp++;
                }
                dp[i][j] = temp;
            }
        }
        return dp[str1.length() - 1][str2.length() - 1];
    }
}
