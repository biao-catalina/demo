package com.leetcode;

import java.util.*;

public class Demo {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i >= 1) {
                if (nums[i - 1] == nums[i])
                    continue;
            }
            List<List<Integer>> temp = twosum(i + 1, nums.length - 1, nums, -nums[i]);
            if (temp.size() != 0) {
                for (List<Integer> t : temp) {
                    List<Integer> t1 = new ArrayList<>();
                    t1.add(nums[i]);
                    t1.addAll(t);
                    result.add(t1);
                }
            }
        }
        return result;


    }

    List<List<Integer>> twosum(int i, int j, int[] nums, int required) {
        List<List<Integer>> result = new ArrayList<>();
        while (i < j) {
            if (nums[i] + nums[j] > required)
                j--;
            else if (nums[i] + nums[j] == required) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(nums[j]);
                result.add(temp);
                while (i < j && nums[i] == nums[i + 1])
                    i++;
                while (i < j && nums[j] == nums[j - 1])
                    j--;
                i++;
                j--;
            } else
                i++;

        }
        return result;
    }
}
