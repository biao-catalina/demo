package com.algorithm.leetcode.september;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Matrix {

    public static void main(String[] args) {
        Matrix m = new Matrix();
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};

        int[][] ints = m.updateMatrix(mat);
        System.out.println(Arrays.deepToString(ints));

        System.out.println(Arrays.deepToString(m.updateMatrixDp(mat)));
    }

    /**
     * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
     * The distance between two adjacent cells is 1.
     */
    public int[][] updateMatrixDp(int[][] matrix) {
        if (matrix.length == 0) return null;
        int maxX = matrix.length;
        int maxY = matrix[0].length;
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                if (matrix[i][j] != 0) {
                    matrix[i][j] = Integer.MAX_VALUE - 10000;
                    if (i > 0) matrix[i][j] = Math.min(matrix[i][j], matrix[i - 1][j] + 1);
                    if (j > 0) matrix[i][j] = Math.min(matrix[i][j], matrix[i][j - 1] + 1);
                }
            }
        }
        for (int i = maxX - 1; i >= 0; i--) {
            for (int j = maxY - 1; j >= 0; j--) {
                if (i < maxX - 1) matrix[i][j] = Math.min(matrix[i][j], matrix[i + 1][j] + 1);
                if (j < maxY - 1) matrix[i][j] = Math.min(matrix[i][j], matrix[i][j + 1] + 1);
            }
        }

        return matrix;
    }


    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0) return null;
        int maxX = matrix.length;
        int maxY = matrix[0].length;
        int[][] arr = new int[maxX][maxY];

        ArrayDeque<Pair> queue = new ArrayDeque<>();

        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                if (matrix[i][j] == 0) {
                    arr[i][j] = 0;
                    queue.add(new Pair(i, j));
                } else {
                    arr[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] vector = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            Pair pop = queue.pop();
            for (int[] ints : vector) {
                int nexti = pop.x + ints[0];
                int nexty = pop.y + ints[1];
                if (nexti >= 0 && nexty >= 0 && nexti < maxX && nexty < maxY) {
                    if (arr[nexti][nexty] > arr[pop.x][pop.y] + 1) {
                        arr[nexti][nexty] = arr[pop.x][pop.y] + 1;
                        queue.add(new Pair(nexti, nexty));
                    }
                }
            }
        }
        return arr;
    }


}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
