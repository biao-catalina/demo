package com.leetcode;

import java.util.Arrays;

public class BinarySearchSolution {


    public static void main(String[] args) {
        BinarySearchSolution s = new BinarySearchSolution();
        int[] ints = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(s.searchRange1(ints, 8)));
//        int i = s.xorOperation(4, 4);
//        System.out.println(s.findMin(ints));
//        System.out.println(s.minEatingSpeed(ints, k));
    }


    public int[] searchRange(int[] nums, int target) {


        int[] res = new int[]{nums.length, -1};
        binarySearch(nums, target, 0, nums.length, res);

        if (res[0] == nums.length) res[0] = -1;
        return res;
    }


    void binarySearch(int[] nums, int target, int left, int right, int[] res) {

        if (left < right) {
            int mid = left + (right - left) / 2;
            System.out.println(1);

            //If value found store index in array
            if (nums[mid] == target) {
                res[0] = Math.min(res[0], mid);
                res[1] = Math.max(res[1], mid);
            }

            binarySearch(nums, target, left, mid, res);
            binarySearch(nums, target, mid + 1, right, res);
        }
    }


    public int[] searchRange1(int[] nums, int target) {
        int[] res = new int[]{2, -1};
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            System.out.println(1);
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                res[0] = searchFirstRange(nums, target, left, mid);
                res[1] = searchLastRange(nums, target, mid, right);
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return res;
    }

    private int searchFirstRange(int[] nums, int target, int left, int right) {
        while (left <= right) {
            System.out.println(1);
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid] > nums[mid - 1]) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return -1;
    }

    private int searchLastRange(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid] < nums[mid + 1]) {
                    return mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            System.out.println(1);
        }
        return -1;
    }


    int xorOperation(int n, int start) {
        int ret = 2 * xorOperationA(n, start / 2);
        if ((n & start & 1) > 0) {
            ret++;
        }
        return ret;
    }

    int xorOperationB(int n, int start) {
        if (n % 2 == 0)
            return (n / 2) & 1;
        else
            return ((n / 2) & 1) ^ (start + n - 1);
    }

    int xorOperationA(int n, int start) {
        if ((start & 1) > 0)
            return (start - 1) ^ xorOperationB(n + 1, start - 1);
        else
            return xorOperationB(n, start);
    }


    public int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;
        while (min < max) {
            int mid = (min + max) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < nums[min]) {
                if (target > nums[min]) {
                    max = mid;
                } else {
                    min = mid + 1;
                }
            }
            if (nums[mid] > nums[max]) {
                min = mid + 1;
            } else {

            }
        }

        return nums[min];
    }

    public int findMin(int[] nums) {
        int min = 0;
        int max = nums.length - 1;
        while (min < max) {
            int mid = (min + max) / 2;
            if (nums[mid + 1] < nums[mid]) return nums[mid + 1];
            if (nums[mid] < nums[min]) {
                max = mid;
            } else if (nums[mid] > nums[max]) {
                min = mid + 1;
            } else return nums[0];
        }

        return nums[min];
    }


    public int minEatingSpeed(int[] piles, int H) {
        if (piles.length > H) return -1;

        int max, min = 1;
        max = piles[0];

        for (int i = 1; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        while (min < max) {
            int mid = (min + max) / 2;
            int count = 0;
            for (int i = 0; i < piles.length; i++) {
                count += (piles[i] - 1) / mid + 1;
                if (count > H) {
                    break;
                }
            }
            if (count <= H) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }
}
