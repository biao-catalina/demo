package com.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class UniquePath {

    public static void main(String[] args) {

        UniquePath u = new UniquePath();

        int[][] array = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}};

        System.out.println(u.uniquePathsIII(array));


//        System.out.println(u.uniquePaths(7, 3));

        int[][] arr = {{0, 0}, {1, 1}, {0, 0}
        };

//        System.out.println(u.uniquePathsWithObstacles(arr));

    }

    public int uniquePathsIII(int[][] grid) {
        int startX = 0, startY = 0;
        int walkableSteps = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 0) {
                    walkableSteps++;
                }
            }
        }

        return dfs(startX, startY, grid, 0, walkableSteps);

    }

    private int dfs(int x, int y, int[][] grid, int step, int walkableSteps) {

        if (x >= grid.length || y >= grid[0].length || x < 0 || y < 0 || grid[x][y] == -1) {
            return 0;
        }

        if (grid[x][y] == 2) {
            if (step - 1 == walkableSteps) {
                return 1;
            } else {
                return 0;
            }
        }

        grid[x][y] = -1;
        int sum = dfs(x + 1, y, grid, step + 1, walkableSteps)
                + dfs(x, y + 1, grid, step + 1, walkableSteps)
                + dfs(x - 1, y, grid, step + 1, walkableSteps)
                + dfs(x, y - 1, grid, step + 1, walkableSteps);

        grid[x][y] = 0;
        return sum;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid[0].length;
        int n = obstacleGrid.length;

        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            } else {
                dp[0][i] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            } else {
                dp[i][0] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[n - 1][m - 1];
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }


}
