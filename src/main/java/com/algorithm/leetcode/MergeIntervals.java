package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals me = new MergeIntervals();
        int[][] intervals = {{3, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(me.merge(intervals)));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        for (int[] interval : intervals) {
            
        }
        return null;
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]));
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            if (list.isEmpty()) {
                list.add(interval);
            } else {
                int[] previous = list.get(list.size() - 1);
                if (previous[1] >= interval[0]) {
                    if (previous[1] < interval[1]) {
                        list.set(list.size() - 1, new int[]{previous[0], interval[1]});
                    }
                } else {
                    list.add(interval);
                }
            }
        }
        list.toArray(new int[list.size()][2]);
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
