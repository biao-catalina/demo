package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 6}, {8,10}, {14, 15}};
        MergeIntervals m = new MergeIntervals();
        System.out.println(Arrays.deepToString(m.merge(arr)));
    }

    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] last = stack.peek();
            if (last[1] >= intervals[i][0]) {
                if (last[1] < intervals[i][1]) {
                    stack.pop();
                    stack.push(new int[]{last[0], intervals[i][1]});
                }
            } else {

                stack.push(intervals[i]);
            }
        }

        int size = stack.size();
        int[][] arr = new int[size][2];
        while (!stack.isEmpty()) {
            arr[size-- - 1] = stack.pop();
        }

        return arr;
    }
}
