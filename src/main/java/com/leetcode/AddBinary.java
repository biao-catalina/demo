package com.leetcode;

public class AddBinary {

    public static void main(String[] args) {
        AddBinary add = new AddBinary();
//        System.out.println(add.addBinary("1010", "1011"));
        System.out.println(add.mySqrt(2147395599));
    }

    public int mySqrt(int x) {
        long left = 0;
        long right = x / 2;
        while (left <= right) {
            long mid = (left + right) / 2;
            if ((mid * mid) < x) {
                left = mid + 1;
                if (left * left > x) return (int)mid;
            } else {
                right = mid - 1;
            }
        }
        return (int)left;
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        String maxStr = a.length() > b.length() ? a : b;
        String minStr = a.length() > b.length() ? b : a;
        int diff = maxStr.length() - minStr.length();
        for (int i = maxStr.length() - 1; i >= 0; i--) {
            int poi = maxStr.charAt(i) + carry;
            if (i >= diff) {
                poi += minStr.charAt(i - diff) - '0';
            }
            if (poi < '2') {
                sb.append((char) poi);
                carry = 0;
            } else {
                sb.append((char) (poi - 2));
                carry = 1;
            }
        }
        if (carry == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
