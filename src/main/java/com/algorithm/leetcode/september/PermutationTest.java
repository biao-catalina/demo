package com.algorithm.leetcode.september;

import java.util.Arrays;


public class PermutationTest {
    public static void main(String[] args) {
        PermutationTest t = new PermutationTest();
        int[] arr = {1, 2, 3, 4};
        t.permutate(arr);
    }

    public void permutate(int[] arr) {
        permutate(arr, 0);
    }

    public void permutate(int[] arr, int start) {
        if (start == arr.length) {
            System.out.println(Arrays.toString(arr));
        }
        for (int i = start; i < arr.length; i++) {
            swap(arr, i, start);
            permutate(arr, start + 1);
            swap(arr, start, i);
        }
    }

    private void swap(int[] arr, int start, int end) {
        if (start == end) return;
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
