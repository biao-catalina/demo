package com.leetcode;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();
        String s = "()[]{}";

//        System.out.println(v.isValid(s));
        int i = -2;
        System.out.println(v.toHex(i));
        System.out.println(Integer.toHexString(i));
        System.out.println(Integer.toBinaryString(Math.abs(i)));
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Long.toBinaryString(4294967296L).length());

    }


    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        long n = num;
        if (n < 0) n += Math.pow(2, 32);
        System.out.println(Long.toBinaryString(n));
        long mod = 0;
        while (n > 0) {
            mod = n % 16;
            n = n / 16;
            sb.append(convertNumToHexChar(mod));
        }
//        sb.append(convertNumToHexChar(mod));
        return sb.reverse().toString();
    }

    private Object convertNumToHexChar(long mod) {
        if (mod < 10) {
            return mod;
        }
        return ((char) ('a' + (mod - 10)));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                Character pop = stack.peek();
                if (!isParentThesesMatch(pop, s.charAt(i))) {
                    stack.push(s.charAt(i));
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isParentThesesMatch(char first, char second) {
        return first == '[' && second == ']' || first == '(' && second == ')' || first == '{' && second == '}';
    }
}
