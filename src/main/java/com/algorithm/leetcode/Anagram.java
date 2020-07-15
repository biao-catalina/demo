package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {

    public static void main(String[] args) {

        boolean flag = true;
        boolean t = false;
        flag |= t;
        flag = flag || true;
        Anagram a = new Anagram();
        System.out.println(a.findAnagrams("cbaebabacd", "abc"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] need = new int[128];
        int[] window = new int[128];


        for (int i = 0; i < p.length(); i++) {
            need[p.charAt(i)]++;
        }

        int left = 0, right = 0, count = 0;
        while (right < s.length()) {
            char cur = s.charAt(right++);
            if (need[cur] > 0) {
                window[cur]++;
                if (need[cur] >= window[cur]) {
                    count++;
                }
            }
            while (count == p.length()) {
                if (right - left == p.length()) result.add(left);
                char prev = s.charAt(left++);
                if (need[prev] > 0) {
                    window[prev]--;
                    if (need[prev] > window[prev]) {
                        count--;
                    }
                }
            }
        }

        return result;
    }

    public void canPartition() {

        System.out.println();
    }

    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> result = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            int key = p.charAt(i) - 'a';
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }


        int i = 0, j = 0;
        int count = 0;
        Map<Integer, Integer> tempMap = new HashMap<>(map);

        while (j < s.length()) {
            int key = s.charAt(j) - 'a';
            j++;
            if (tempMap.containsKey(key) && tempMap.get(key) > 0) {
                tempMap.put(key, tempMap.get(key) - 1);
                count++;
            } else {
                count = 0;
                tempMap = new HashMap<>(map);
                j = ++i;
            }
            if (count == p.length()) {
                count = 0;
                result.add(j - p.length());
                tempMap = new HashMap<>(map);
                j = ++i;
            }
        }
        return result;
    }
}
