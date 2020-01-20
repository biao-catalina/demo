package com.algorithm.sort;

import java.util.Arrays;

/**
 * @author admin
 * @description
 * @dateTime 2020-01-20 11:01:00
 */
public class QuickSort2 {
    public static void qSort(int[] data, int leftPoint, int rightPoint) {
        int left = leftPoint;
        int right = rightPoint;
        int base = data[left];
        while (left < right) {
            while (left < right) {
                if (data[right] < base) {
                    data[left] = data[right];
                    data[right] = base;
                    left++;
                    break;
                }
                right--;
            }
            while (left < right) {
                if (data[left] > base) {
                    data[right] = data[left];
                    data[left] = base;
                    right--;
                    break;
                }
                left++;
            }

        }

        if (left > leftPoint) {
            qSort(data, leftPoint, left - 1);
        }
        if (right < rightPoint) {
            qSort(data, right + 1, rightPoint);
        }
    }

    public static void main(String[] args) {
        int[] data = {45, 28, 16, 90, 50, 80, 100, 10};
        qSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }
}
