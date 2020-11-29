package com.leetcode;

public class SpiralMatrix {

    public static void main(String[] args) {
        SpiralMatrix sm = new SpiralMatrix();
//        int[][] ints = sm.generateMatrix(4);
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(sm.minPathSum(grid));
    }


    public int minPathSum(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[n - 1][m - 1];


        // bottom-up
/*        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (j < m - 1 && i < n - 1) {
                    grid[i][j] += Math.min(grid[i][j + 1], grid[i + 1][j]);
                } else if (j < m - 1) {
                    grid[i][j] += grid[i][j + 1];
                } else if (i < n - 1) {
                    grid[i][j] += grid[i + 1][j];
                }
            }
        }
        return grid[0][0];*/
    }


    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int total = n * n + 10;
        int i = 11;
        int v = 0;
        int h = -1;
        while (i <= total) {

            // right order
            while (h < n - 1 && arr[v][h + 1] == 0) {
                arr[v][++h] = i++;
            }

            //down order
            while (v < n - 1 && arr[v + 1][h] == 0) {
                arr[++v][h] = i++;
            }

            // left order
            while (h > 0 && arr[v][h - 1] == 0) {
                arr[v][--h] = i++;
            }

            // up order
            while (v > 0 && arr[v - 1][h] == 0) {
                arr[--v][h] = i++;
            }

        }
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ,");
            }
            System.out.println();
        }
//        System.out.println(Arrays.deepToString(arr));
        return arr;
    }
}
