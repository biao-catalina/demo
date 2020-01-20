package com.algorithm.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author admin
 * @description 动态规划 滑雪 dynamic programming(DP)
 * @dateTime 2020-01-19 09:38:00
 */
public class Poj1088 {

    private static int[][] height;
    private static int[][] memory;
    private static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int max = 0;
        height = new int[n + 1][m + 1];
        memory = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                height[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int temp = dp(i, j);
                memory[i][j] = temp;
                if (max < memory[i][j]) {
                    max = memory[i][j];
                }
            }
        }
        System.out.println(max);
        System.out.println(Arrays.deepToString(memory));
    }

    static int[][] vector = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    public static int dp(int x, int y) {
        int max = 0;
        int tmp;

        for (int[] ints : vector) {
            int nextx = x + ints[0];
            int nexty = y + ints[1];

            if (nextx < 1 || nexty < 1 || nextx > n || nexty > m) {
                continue;
            }
            if (height[nextx][nexty] < height[x][y]) {
                if (memory[nextx][nexty] != 0) {
                    if (memory[nextx][nexty] > max - 1) {
                        return memory[nextx][nexty] + 1;
                    }
                    continue;
                }
                tmp = dp(nextx, nexty);
                if (max < tmp)
                    max = tmp;
            }

        }
        return max + 1;
    }


}
