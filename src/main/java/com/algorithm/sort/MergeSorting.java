package com.algorithm.sort;

import java.util.Arrays;

public class MergeSorting {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        MergeSorting m = new MergeSorting();
        System.out.println(Arrays.toString(m.mergeSort(arr)));
    }

    public int[] mergeSort(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        divide(arr, left, right);

        return arr;
    }

    private void divide(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (left < mid) {
            divide(arr, left, mid);
            divide(arr, mid + 1, right);
        }

        sort(arr, left, right, mid);

    }

    private void sort(int[] arr, int left, int right, int mid) {
        if (right - left == 1) {
            if (arr[left] > arr[right]) {
                arr[right] = arr[right] + arr[left];
                arr[left] = arr[right] - arr[left];
                arr[right] = arr[right] - arr[left];
            }
        } else {
            int[] tempArr = new int[right - left + 1];
            int leftPos = left;
            int rightPos = mid + 1;
            int tempArrPos = 0;
            while (leftPos <= mid && rightPos <= right) {
                if (arr[leftPos] < arr[rightPos]) {
                    tempArr[tempArrPos++] = arr[leftPos++];
                } else {
                    tempArr[tempArrPos++] = arr[rightPos++];
                }
            }
            while (leftPos <= mid) {
                tempArr[tempArrPos++] = arr[leftPos++];
            }
            while (rightPos <= right) {
                tempArr[tempArrPos++] = arr[rightPos++];
            }
            for (int value : tempArr) {
                arr[left++] = value;
            }
        }
    }
}
