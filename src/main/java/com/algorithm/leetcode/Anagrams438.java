package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Anagrams438 {

    public static void main(String[] args) {
        Anagrams438 demo = new Anagrams438();
        String s = "cbaebabacd", p =
                "abc";
        System.out.println(demo.findAnagrams(s, p));
    }

    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length(), n = p.length();
        if (n > m) return new ArrayList<>();

        int[] cnt_arr = new int[26];
        for (int i = 0; i < n; i++) {
            cnt_arr[s.charAt(i) - 'a']++;
            cnt_arr[p.charAt(i) - 'a']--;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = n; i < m; i++) {
            if (areAllZeroes(cnt_arr)) {
                list.add(i - n);
            }
            cnt_arr[s.charAt(i) - 'a']++;
            cnt_arr[s.charAt(i - n) - 'a']--;
        }
        if (areAllZeroes(cnt_arr)) {
            list.add(m - n);
        }

        return list;
    }

    boolean areAllZeroes(int[] cnt_arr) {
        for (int value : cnt_arr) {
            if (value != 0) return false;
        }
        return true;
    }
}
