package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class QueueBackTrack {


    public static void main(String[] args) {
        QueueBackTrack q = new QueueBackTrack();
        q.queue(8);
    }

    public void queue(int n) {
        ans = new ArrayList<>();
        queue(n, new LinkedList<>());
        System.out.println(ans);
    }

    List<List<Point>> ans;

    public void queue(int n, LinkedList<Point> list) {

        if (list.size() == n) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isGood(i, j, list)) {
                    list.add(new Point(i, j));
                    queue(n, list);
                    list.removeLast();
                }
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean isGood(int x, int y, List<Point> points) {
     /*   if (points.size() > 0) {
            Point point = points.get(points.size() - 1);
            if (x < point.x || y < point.y) return false;
        }*/
        for (Point point : points) {
            if (x == point.x || y == point.y || Math.abs(x - point.x) == Math.abs(y - point.y)) {
                return false;
            }
        }
        return true;
    }
}
