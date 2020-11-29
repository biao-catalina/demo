package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findBestValue(new int[]{1547, 83230, 57084, 93444, 70879}, 71237));


//        System.out.println(s.minDays(new int[]{1, 1, 1, 9, 1, 1}, 2, 3));
//        s.moveZeroes(new int[]{0, 1, 0, 3, 12});
        //        System.out.println(s.maxProduct(new int[]{2, 3, 2, 4, -5}));
//        System.out.println(s.maxSubArrayLen(new int[]{7, 1, -1, 5, -2, 3}, 3));
//        System.out.println(Arrays.toString(s.productExceptSelf(new int[]{2, 4, 5, 8})));
    }


    public int findBestValue(int[] arr, int target) {
        int average = target / arr.length;
        if (target % arr.length > arr.length / 2) {
            average += 1;
        }
        int min, max;
        min = max = 0;
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += Math.min(arr[i], average);
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        if (min >= average || max <= average) {
            return average;
        }
        int left = average;
        int right = max;
        int diff = Math.abs(target - total);
        int poi = average;
        while (left < right) {
            int mid = (left + right) / 2;
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += Math.min(arr[i], mid);
            }
            int abs = Math.abs(sum - target);
                right = mid;
            if (abs < diff) {
                diff = abs;
                poi = mid;
            }
        }
        return poi;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length == 0 || bloomDay.length < m * k) return -1;

        int min, max;
        min = max = bloomDay[0];
        for (int i = 1; i < bloomDay.length; i++) {
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }

        while (min < max) {
            int mid = (min + max) / 2;
            int count = 0;
            int bouquet = 0;

            for (int i = 0; i < bloomDay.length; i++) {
                if (bloomDay[i] > mid) {
                    count = 0;
                } else if (++count == k) {
                    count = 0;
                    bouquet++;
                }
                if (bloomDay.length - 1 - i + count + bouquet * k < m * k || bouquet == m) {
                    break;
                }
            }

            if (bouquet >= m) {
                max = mid;
            } else {
                min = mid + 1;
            }

        }
        return min;

    }

    public int minDays1(int[] A, int m, int k) {
        int n = A.length, left = 1, right = (int) 1e3;
        if (m * k > n) return -1;
        int count = 0;
        while (left < right) {
            count++;
            int mid = (left + right) / 2, flow = 0, bouq = 0;
            for (int j = 0; j < n; ++j) {
                if (A[j] > mid) {
                    flow = 0;
                } else if (++flow >= k) {
                    bouq++;
                    flow = 0;
                }
            }
            if (bouq < m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(count);
        return left;
    }

    public void moveZeroes(int[] nums) {
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                if (zeroCount > 0) {
                    nums[i - zeroCount] = nums[i];
                    nums[i] = 0;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }


    public int maxProduct(int[] nums) {

        int max, min;
        max = min = nums[0];
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                max = Math.max(nums[i], max * nums[i]);
                min = Math.min(nums[i], min * nums[i]);

            } else {
                int temp = max;
                max = Math.max(nums[i], min * nums[i]);
                min = Math.min(nums[i], temp * nums[i]);
            }
            result = Math.max(result, max);
        }
        return result;
    }

    private int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int result = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                result = Math.max(result, i - map.get(sum - k));
            }
            map.putIfAbsent(sum, i);
        }


        return 0;
    }


    public int maxSubArrayLen1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                result = Math.max(result, i - map.get(sum - k));
            }
            map.putIfAbsent(sum, i);
        }

        return result;
    }

    private int[] productExceptSelf(int[] ints) {
        int n = ints.length;
        int[] output = new int[n];
        output[0] = 1;
        for (int i = 1; i < ints.length; i++) {
            output[i] = output[i - 1] * ints[i - 1];
        }
        int temp = 1;
        for (int i = n - 2; i >= 0; i--) {
            temp *= ints[i + 1];
            output[i] *= temp;
        }
        return output;
    }


    public int[] productExceptSelf11(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        Arrays.fill(output, 1);
        int temp = 1;
        for (int i = 1; i < n; i++) {
            temp *= nums[i - 1];
            output[i] *= temp;
        }

        temp = 1;
        for (int i = n - 2; i >= 0; i--) {
            temp *= nums[i + 1];
            output[i] *= temp;
        }

        return output;
    }
}
