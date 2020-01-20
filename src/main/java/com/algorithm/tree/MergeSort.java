package com.algorithm.tree;

import java.util.Arrays;

// 归并排序
public class MergeSort {

    public static void mergeSort(int[] data, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(data, left, mid);
            mergeSort(data, mid + 1, right);

            merge(data, left, mid, right);
        }
    }

    public static void merge(int[] data, int left, int mid, int right) {
        int[] temp = new int[data.length];

        int leftPoint = left;
        int rightPoint = mid + 1;

        int loc = left;
        while (leftPoint <= mid && rightPoint <= right) {
            if (data[leftPoint] <= data[rightPoint]) {
                temp[loc] = data[leftPoint];
                loc++;
                leftPoint++;
            } else {
                temp[loc] = data[rightPoint];
                loc++;
                rightPoint++;
            }
        }
        while (leftPoint <= mid) {
            temp[loc++] = data[leftPoint++];

        }
        while (rightPoint <= right) {
            temp[loc++] = data[rightPoint++];
        }
        for (int i = left; i <= right; i++) {
            data[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] data = {32, 43, 65, 54, 123, 65, 76, 34,565};
//        int[] data = {9, 5, 6, 8, 0, 3, 7, 1};
        mergeSort(data, 0, data.length - 1);

        System.out.println(Arrays.toString(data));
    }
}
