package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permutations p = new Permutations();
//        List<List<Integer>> permute = p.permute(nums);
//        System.out.println(permute);

    }

    List<List<Integer>> ans;

    public List<List<Integer>> permute1(int[] nums) {
        ans = new ArrayList<>();
        permute1(nums, new LinkedList<>());
        return ans;
    }

    public void permute1(int[] nums, LinkedList<Integer> list) {

        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(num);
                if (list.size() == nums.length) {
                    ans.add(new ArrayList<>(list));
                    list.removeLast();
                } else {
                    permute1(nums, list);
                }
            }
        }
    }


    void permute(int[] nums, LinkedList<Integer> cur) {
        if (cur.size() == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int num : nums) {
            if (!cur.contains(num)) {
                cur.add(num);
                permute(nums, cur);
                cur.removeLast();
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        permute(nums, new LinkedList<>());
        return ans;
    }
}
