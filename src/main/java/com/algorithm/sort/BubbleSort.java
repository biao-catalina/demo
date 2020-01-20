package com.algorithm.sort;

import java.util.Arrays;

/**
 * @author admin
 * @description
 * @dateTime 2020-01-19 17:19:00
 */
public class BubbleSort {

    public static void main(String[] args) {

//        int[] arr = {23, 4, 5, 34, 786};
        int[] arr = {23, 45, 12, 43, 65, 7, 4, 5, 34, 786};
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                count++;
                if (arr[i] < arr[j]) {
                    arr[i] = arr[i] + arr[j];
                    arr[j] = arr[i] - arr[j];
                    arr[i] = arr[i] - arr[j];
                }
            }
        }
        System.out.println(count);
        System.out.println(Arrays.toString(arr));

    }
}
