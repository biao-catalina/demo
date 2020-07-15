package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    int count;

    public static void main(String[] args) {
        CombinationSum c = new CombinationSum();
        System.out.println(c.combinationSum(new int[]{2, 3, 5}, 8));
        System.out.println(c.count);
    }

    private void util(int[] arr, int target, List<List<Integer>> res, List<Integer> ls, int start) {
        count++;
        if (target == 0) {
            res.add(new ArrayList<>(ls));
        } else if (target > 0) {
            for (int i = start; i < arr.length; i++) {
                if (arr[i] > target) {
                    break;
                }
                ls.add(arr[i]);
                util(arr, target - arr[i], res, ls, start);
                ls.remove(ls.size() - 1); //backtracking
                start += 1;// to avoid duplicates by shrinking search space
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        util(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }
}
