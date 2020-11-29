package com.algorithm.leetcode;

public class SlideWindow {

    public static void main(String[] args) {
        SlideWindow s = new SlideWindow();
        int[] nums = {10, 1, 2, 4, 7, 2};
        int limit = 5;

        String s1 = "WWEQERQWQWWRWWERQWEQ";

        System.out.println(s.balancedString(s1));


        System.out.println(s.longestSubarray(nums, limit));
        System.out.println(s.longestSubarray2(nums, limit));
    }

    public int balancedString(String s) {
        int n = s.length();
        int[] arr = new int[4];
        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
                case 'Q' :
                    arr[0]++;
                    break;
                case 'W':
                    arr[1]++;
                    break;
                case 'E':
                    arr[2]++;
                    break;
                case 'R':
                    arr[3]++;
                    break;

            }
        }
        int result = 0;
        int divide = n / 4;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > divide) {
                result += arr[i] - divide;
            }
        }

        return result;
    }


    public int numberOfSubstrings2(String s) {
        int left = 0, right = 0;
        int result = 0;
        int[] arr = new int[3];

        while (right < s.length()) {
            arr[s.charAt(right++) - 'a']++;

            while (arr[0] > 0 && arr[1] > 0 && arr[2] > 0) {
                result += s.length() - right + 1;
                arr[s.charAt(left++) - 'a']--;
            }
        }

        return result;
    }


    public int numberOfSubstrings(String s) {
        int i = 0, j = 0, ans = 0;
        int[] map = new int[3];
        while (j < s.length()) {
            while (j < s.length() && (map[0] < 1 || map[1] < 1 || map[2] < 1)) {
                map[s.charAt(j) - 'a']++;
                j++;
            }
            while (i < j && (map[0] > 0 && map[1] > 0 && map[2] > 0)) {
                ans += s.length() - j + 1;
                map[s.charAt(i) - 'a']--;
                i++;
            }
        }
        return ans;
    }


    public int longestSubarray2(int[] nums, int limit) {
        if (nums == null || nums.length == 0)
            return 0;

        int len = nums.length, left = 0, min = nums[0], max = nums[0], res = 0;

        for (int i = 0; i < len; i++) {
            int diff = Math.max(Math.abs(nums[i] - min), Math.abs(max - nums[i]));
            if (diff <= limit) {
                min = Math.min(nums[i], min);
                max = Math.max(nums[i], max);
                res = Math.max(res, i - left + 1);
            } else {
                int right = i - 1;
                min = max = nums[i];
                while (left < right && Math.abs(nums[i] - nums[right]) <= limit) {
                    min = Math.min(nums[right], min);
                    max = Math.max(nums[right], max);
                    right--;
                }
                left = right + 1;
            }
        }
        return res;
    }


    public int longestSubarray(int[] nums, int limit) {
        int i = 0;
        int j = 0;

        int min = nums[0];
        int max = nums[0];

        int ans = 0;
        int count = 0;
        while (j < nums.length) {
            min = Math.min(min, nums[j]);
            max = Math.max(max, nums[j]);
            if (Math.abs(max - min) <= limit) {
                ans = Math.max(ans, j - i + 1);
            } else {
                i++;
                while (i > 0 && nums[i - 1] == nums[i]) i++;
                min = nums[i];
                max = nums[i];
                j = i;
            }
            j++;
            count++;
        }
//        System.out.println(count);
        return ans;
    }
}
