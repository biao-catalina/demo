package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        ThreeSum t = new ThreeSum();
        List<List<Integer>> lists = t.threeSum(nums);
        System.out.println(lists);
    }

    List<List<Integer>> result;

    public List<List<Integer>> threeSum(int[] nums) {
        result = new ArrayList<>();
        threeSum(nums, new LinkedList<>(), 0);
        return result;
    }

    public void threeSum(int[] nums, LinkedList<Integer> list, int index) {

        if (list.size() == 3) {
            if (list.stream().mapToInt(a -> a).sum() == 0) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (nums.length - i + list.size() < 3) break;
//            if (i < index) continue;
            list.add(nums[i]);
            threeSum(nums, list, ++index);
            list.removeLast();
        }

    }
}
