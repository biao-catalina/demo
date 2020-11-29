package com.algorithm.leetcode;

public class Container11 {


    public static int max(int[] height) {
        int
                area = 0,
                i = 0,
                z = height.length - 1;

        while (i < z) {
            if (height[i] < height[z]) {
                area = Math.max(area, height[i] * (z - i));
                while (++i < z && height[i] < (height[i - 1] + 1)) {
                    System.out.println(height[i - 1]);
                }
            } else {
                area = Math.max(area, height[z] * (z - i));
                while (i < --z && height[z] < (height[z + 1] + 1)) {
                }
            }
        }
        return area;
    }


    public static int maxCapicity(int[] arr) {
        int max = 0, l = 0, r = arr.length - 1;

        while (l < r) {
            max = Math.max(max, Math.min(arr[l], arr[r]) * (r - l));
            if (arr[l] < arr[r]) {
                int poi = l + 1, height = arr[l];
                while (poi < r && arr[poi] <= height) {
                    poi++;
                }
                l = poi;
            } else {
                int poi = r - 1, height = arr[r];
                while (l < poi && arr[poi] <= height) {
                    poi--;
                }
                r = poi;
            }
        }


        return max;
    }


    public static void main(String[] args) {
        int[] arr = {9, 6, 7, 8, 5, 4, 8, 3, 10};
        max(arr);
        int max = 0;
        int times = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                int capacity = Math.min(arr[i], arr[j]) * (i - j);
                max = Math.max(max, capacity);
                times++;
            }

        }
        System.out.println(max);
        System.out.println(times);
    }

    public static int maxArea(int[] height) {
        int res = Integer.MIN_VALUE, l = 0, r = height.length - 1;
        while (l < r) {
            res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
            if (height[l] <= height[r]) {
                int temp = l, ht = height[l];

                while (temp < r && height[temp] <= ht) {
                    temp++;
                }

                l = temp;
            } else {
                int temp = r, ht = height[r];

                while (temp > l && height[temp] <= ht) {
                    temp--;
                }

                r = temp;
            }

        }
        return res;
    }
}
