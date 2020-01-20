package com.algorithm.tree;

import java.util.Arrays;

/**
 * @author admin
 * @description
 * @dateTime 2020-01-20 15:21:00
 */
public class MergeSort2 {

    public static void main(String[] args) {
        int[] data = {28, 45, 16, 90, 50, 80, 100, 10, 65, 79};
        mergeSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }

    static void mergeSort(int[] data, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(data, left, mid);
            mergeSort(data, mid + 1, right);
            merge(data, mid, left, right);
        }
    }

    static void merge(int[] data, int mid, int left, int right) {

        //如果是相邻的2个数字 直接替换 不用创建数组来复制数据
        if (right - left == 1) {
            if (data[left] > data[right]) {
                data[left] = data[left] + data[right];
                data[right] = data[left] - data[right];
                data[left] = data[left] - data[right];
            }
            return;
        }

        int[] temp = new int[data.length];
        int ll = left;
        int rr = mid + 1;
        int loc = left;
        while (ll <= mid && rr <= right) {
            if (data[ll] < data[rr]) {
                temp[loc++] = data[ll++];
            } else {
                temp[loc++] = data[rr++];
            }
        }
        while (ll <= mid) {
            temp[loc++] = data[ll++];
        }
        while (rr <= right) {
            temp[loc++] = data[rr++];
        }
        System.arraycopy(temp, left, data, left, right + 1 - left);
    }

}
