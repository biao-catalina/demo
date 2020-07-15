package com.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Path {

    public static void main(String[] args) {
        Path p = new Path();
//        String s = p.simplifyPath("/a//b////c/d//././/..");
        System.out.println(Arrays.deepToString(p.generateMatrix(4)));
    }

    public int[][] generateMatrix(int n) {

        int total = n * n;
        int[][] grid = new int[n][n]; // This will initialize every element with 0

        int i = 1;
        int r = 0, c = -1;
        while (i <= total) {
            // Go right as long as I can aka the next space is 0
            while (c < n - 1 && grid[r][c+1] == 0) {
                grid[r][++c] = i++;
            }

            // Go down
            while (r < n - 1 && grid[r + 1][c] == 0) {
                grid[++r][c] = i++;
            }

            // Go left
            while (c > 0 && grid[r][c - 1] == 0) {
                grid[r][--c] = i++;
            }
            // Go up
            while (r > 0 && grid[r - 1][c] == 0) {
                grid[--r][c] = i++;
            }
        }

        return grid;
    }

    public String simplifyPath(String path) {
        Deque<String> mDeque = new ArrayDeque<>();
        String[] split = path.split("/");
        for (String s : split) {
            if (s.equalsIgnoreCase("..")) {
                if (!mDeque.isEmpty()) {
                    mDeque.pollLast();
                }
            } else {
                if (!s.equalsIgnoreCase(".") && s.length() > 0) {

                    mDeque.addLast(s);
                }
            }
        }

        if (mDeque.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        do {
            String s = mDeque.pollFirst();
            sb.append("/").append(s);
        } while (!mDeque.isEmpty());
        return sb.toString();
    }
}
