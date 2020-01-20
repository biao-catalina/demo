package com.algorithm.sort;

import java.util.Arrays;

/**
 * @author admin
 * @description
 * @dateTime 2020-01-20 08:33:00
 */
public class SelectSort {
    public static void main(String[] args) {

        int[] arr = {432, 543, 1, 54, 6, 5, 76, 76, 98, 7};
        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                arr[i] = arr[i] + arr[min];
                arr[min] = arr[i] - arr[min];
                arr[i] = arr[i] - arr[min];
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
