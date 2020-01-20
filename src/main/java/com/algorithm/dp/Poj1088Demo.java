package com.algorithm.dp;

/**
 * @author admin
 * @description
 * @dateTime 2020-01-19 11:13:00
 */

import java.util.*;
public class Poj1088Demo {
    private static int height[][], memory[][];
    private static int n, m;// 记录输入数量

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int max = 0;
        height = new int[n + 3][m + 3];
        memory = new int[n + 3][m + 3]; // 避免递归查找时数组越界
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (sc.hasNext()) {
                    height[i][j] = sc.nextInt();
                }
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                int temp = dp(i, j);
                memory[i][j] = temp;
                if(max < memory[i][j]){
                    max = memory[i][j];
                }
            }
        }

        System.out.println(max);
        sc.close();
    }

    public static int dp(int x, int y) {
        int max = 0;
        int tmp;
        if (x < 1 || y < 1 || x > n || y > m) {
            // 已经到达边界
            return 0;
        }
        if (memory[x][y] != 0) {
            // 已经查找过
            return memory[x][y];
        }

        if (height[x][y] > height[x][y + 1]) {
            // 向上查找
            tmp = dp(x, y + 1);
            if (max < tmp)
                max = tmp;
        }
        if (height[x][y] > height[x][y - 1]) {
            // 向下查找
            tmp = dp(x, y - 1);
            if (max < tmp)
                max = tmp;
        }
        if (height[x][y] > height[x - 1][y]) {
            // 向左查找
            tmp = dp(x - 1, y);
            if (max < tmp)
                max = tmp;
        }
        if (height[x][y] > height[x + 1][y]) {
            // 向右查找
            tmp = dp(x + 1, y);
            if (max < tmp)
                max = tmp;
        }

        return max + 1;
    }

}
