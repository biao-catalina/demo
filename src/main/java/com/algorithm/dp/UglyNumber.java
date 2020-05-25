package com.algorithm.dp;

/**
 * 质因数为2，3，5，7的数为丑数 Humble number
 */
public class UglyNumber {
    public static void main(String[] args) {

        int h2 = 1;
        int h3 = 1;
        int h5 = 1;
        int h7 = 1;

        int[] arr = new int[4084];
        arr[1] = 1;
        for (int i = 2; i < 4084; i++) {
            arr[i] = Math.min(arr[h2] * 2, Math.min(arr[h3] * 3, Math.min(arr[h5] * 5, arr[h7] * 7)));
            if (arr[i] == arr[h2] * 2) h2++;
            if (arr[i] == arr[h3] * 3) h3++;
            if (arr[i] == arr[h5] * 5) h5++;
            if (arr[i] == arr[h7] * 7) h7++;
        }
        System.out.println(arr[2]);
        System.out.println(arr[18]);
        System.out.println(arr[20]);
        System.out.println(arr[40]);
        System.out.println(arr[1000]);


    }
}
