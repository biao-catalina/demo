package com.algorithm.leetcode;

public class FriendCircles547 {

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}};

        FriendCircles547 f = new FriendCircles547();
        System.out.println(f.findCircleNum(arr));
    }

    int circlecount;
    int[] parents;

    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }
        int rows = M.length;
        int cols = M[0].length;
        parents = new int[rows];
        circlecount = rows;
        for (int i = 0; i < rows; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(i, j);
                }

            }
        }
        return circlecount;


    }

    public int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    public void union(int a, int b) {
        int groupa = find(a);
        int groupb = find(b);

        if (groupa != groupb) {
            parents[groupa] = groupb;
            circlecount--;
        }
    }

}
