package com.algorithm.graph;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BFS {

    int m; // 行数
    int n; // 列数

    int[][] data;
    boolean[][] mark;

    int[][] vector = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    Queue<Point> queue;


    public BFS(int m, int n, int[][] data) {
        queue = new LinkedBlockingQueue<>(m * n);
        this.m = m;
        this.n = n;
        this.data = data;
        this.mark = new boolean[m][n];
    }

    public void bfs(int startx, int starty, int dx, int dy) {
        if (data[startx][starty] > 0) {
            return;
        }
        mark[startx][starty] = true;
        queue.add(new Point(startx, starty));
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            for (int i = 0; i < vector.length; i++) {
                int nextx = poll.x + vector[i][0];
                int nexty = poll.y + vector[i][1];

                if (nextx < 0 || nextx > m - 1 || nexty < 0 || nexty > n - 1 || data[nextx][nexty] > 0 || mark[nextx][nexty]) {
                    continue;
                }
                if (nextx == dx && nexty == dy) {
                    System.out.println("get it");
                }
                mark[nextx][nexty] = true;
                queue.add(new Point(nextx, nexty));
            }
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
        BFS bfs = new BFS(m, n, data);
        bfs.bfs(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

    }
}


