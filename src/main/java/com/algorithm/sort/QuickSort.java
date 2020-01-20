package com.algorithm.sort;

import java.util.Arrays;

public class QuickSort {

    public static void qSort(int[] data, int left, int right) {
        int ll = left;
        int rr = right;
        int base = data[left];

        while (ll < rr) {
            while (ll < rr && data[rr] >= base) {
                rr--;
            }
            if (ll < rr) {
                data[ll] = data[rr];
                data[rr] = base;
                ll++;
            }
            while (ll < rr && data[ll] <= base) {
                ll++;
            }
            if (ll < rr) {
                data[rr] = data[ll];
                data[ll] = base;
                rr--;
            }
        }
        if (ll > left) {
            qSort(data, left, ll - 1);
        }
        if (rr < right) {
            qSort(data, rr + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] data = {45, 28, 16, 90, 50, 80, 100, 10};
        qSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }
}
