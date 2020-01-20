package com.algorithm.sort;

import java.util.Arrays;

/**
 * @author admin
 * @description
 * @dateTime 2020-01-20 08:50:00
 */
public class ShellSort {


    public void sort() {
        int[] data = {45, 28, 16, 90, 50, 80, 100, 10, 75};

        int step = data.length / 2;

        while (step >= 1) {
            step /= 2;
            for (int i = step; i < data.length; i++) {
                for (int j = i; j >= step; j -= step) {

                }
            }
        }

    }




















    public static void main(String[] args) {
        int[] data = {13, 14, 94, 33, 82, 25, 59, 94, 65, 23, 45, 27, 73, 25, 39, 10};

        int step = 5;
        while (step >= 1) {

            for (int i = step; i < data.length; i++) {
                for (int j = i; j >= step; j -= step) {
                    if (data[j] < data[j - step]) {
                        data[j] = data[j] + data[j - step];
                        data[j - step] = data[j] - data[j - step];
                        data[j] = data[j] - data[j - step];
                    } else {
                        break;
                    }
                }
            }
            step = step / 2;
        }


        System.out.println(Arrays.toString(data));
    }
}
