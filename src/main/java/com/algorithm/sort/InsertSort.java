package com.algorithm.sort;

import java.util.Arrays;

/**
 * @author admin
 * @description
 * @dateTime 2020-01-20 08:50:00
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] data = {45, 28, 16, 90, 50, 80, 100, 10};
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j > 0; j--) {
                if (data[j] < data[j - 1]) {
                    data[j] = data[j] + data[j - 1];
                    data[j - 1] = data[j] - data[j - 1];
                    data[j] = data[j] - data[j - 1];
                } else {
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(data));
    }
}
