package com.algorithm.sort;

import java.util.Arrays;

public class InsertSorting {

    public static void main(String[] args) {
        InsertSorting sort = new InsertSorting();
        int[] arr = {43, 223, 65, 21, 4, 65};
        System.out.println(Arrays.toString(sort.sort(arr)));
    }

    public int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    arr[j] = arr[j] + arr[j - 1];
                    arr[j - 1] = arr[j] - arr[j - 1];
                    arr[j] = arr[j] - arr[j - 1];
                } else break;
            }
        }
        return arr;
    }
}
