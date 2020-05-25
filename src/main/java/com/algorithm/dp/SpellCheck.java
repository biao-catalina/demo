package com.algorithm.dp;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SpellCheck {
    public static void main(String[] args) {
        List<String> dictionay = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String dic = scanner.next();
            if ("#".equals(dic)) {
                break;
            }
            dictionay.add(dic);
        }



    }
}
