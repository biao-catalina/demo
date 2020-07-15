package com.leetcode;

public class Matrix {

    public static void main(String[] args) {
        Matrix m = new Matrix();
        int[][] matrix = {
                {1}
        };

//        System.out.println(m.searchMatrix1(matrix, 2));

        int[] arr = {0,1,0};
        m.sortColors(arr);
        System.out.println(arr);
    }


    public void sortColors(int[] nums) {
        int first = 0;
        int last = nums.length - 1;
        int index = first;
        while (index <= last && first < last) {
            if (nums[index] == 0) {
                nums[index] = nums[first];
                nums[first++] = 0;
            } else if (nums[index] == 2) {
                nums[index] = nums[last];
                nums[last--] = 2;
            } else {
                index++;
            }
        }

    }


    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix.length < 1) return false;
        if (matrix[0].length < 1) return false;
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int i = mid / matrix[0].length;
            int j = mid % matrix[0].length;
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int[] arr = new int[0];

        for (int[] ints : matrix) {
            if (ints.length < 1 || target < ints[0]) return false;
            if (ints[ints.length - 1] >= target) {
                arr = ints;
                break;
            }
        }
        if (arr.length > 0) {
            int left = 0;
            int right = arr.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] == target) return true;
                if (arr[mid] < target) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }
}
