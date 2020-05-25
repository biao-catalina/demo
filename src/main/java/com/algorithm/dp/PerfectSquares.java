package com.algorithm.dp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 完全平方
 */
public class PerfectSquares {
    public static void main(String[] args) {
        PerfectSquares p = new PerfectSquares();
        p.numSquares(20);
    }

    public int numSquares(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] nums = new int[n + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i * i <= n; i++) {
            nums[i * i] = 1;
            map.put(i * i, 1);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; i + j * j < n; j++) {
                if (nums[i + j * j] == 0 || nums[i] + 1 < nums[i + j * j]) {
                    map.put(i + j * j, nums[i] + 1);
                    nums[i + j * j] = nums[i] + 1;
                }
            }
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println(key + "-" + map.get(key));
        }
        return 0;
    }
}
