package com.algorithm.graph;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;


public class DFS {

    int m; // 行数
    int n; // 列数

    int dx;
    int dy;

    int minStep = Integer.MAX_VALUE;

    int[][] data;
    boolean[][] mark;

    int[][] vector = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    Queue<Point> queue;


    public DFS(int m, int n, int dx, int dy, int[][] data) {
        this.dx = dx;
        this.dy = dy;
//        queue = new LinkedBlockingQueue<>(m * n);
        this.m = m;
        this.n = n;
        this.data = data;
        this.mark = new boolean[m][n];
    }

    public void dfs(int x, int y) {
        mark[x][y] = true;
        dfs(x, y, 0);

    }

    public void dfs(int x, int y, int step) {
        if (data[x][y] > 0) {
            return;
        }
        for (int i = 0; i < vector.length; i++) {
            int nextx = x + vector[i][0];
            int nexty = y + vector[i][1];
            if (nextx < 0 || nextx > m - 1 || nexty < 0 || nexty > n - 1 || data[nextx][nexty] > 0 || mark[nextx][nexty]) {
                continue;
            }
            step++;
            if (nextx == dx && nexty == dy) {
                if (step < minStep) {
                    minStep = step;
                }
                System.out.println("get it, step is " + step );
                break;
            }
            mark[nextx][nexty] = true;
            dfs(nextx, nexty, step);
            mark[nextx][nexty] = false;
//            queue.add(new Point(nextx, nexty));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[][] data = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                data[i][j] = scanner.nextInt();
            }
        }
        DFS dfs = new DFS(m, n, scanner.nextInt(), scanner.nextInt(), data);
        dfs.dfs(scanner.nextInt(), scanner.nextInt());
        System.out.println(dfs.minStep);
    }
}


/*
5 4
0 0 1 0
0 0 0 0
0 0 1 0
0 1 0 0
0 0 0 1

3 2
0 0
*/


