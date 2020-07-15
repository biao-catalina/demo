package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {

    public static void main(String[] args) {
        WordSearch w = new WordSearch();

        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};


        System.out.println(w.findWords(board, words));


    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (wordIsInArr(board, word)) {
                res.add(word);
            }
        }
        return res;
    }

    public boolean wordIsInArr(char[][] arr, String word) {


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == word.charAt(0)) {
                    if (dfs(arr, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] arr, String word, int x, int y, int step) {
        if (step == word.length()) return true;
        if (x >= arr.length || y >= arr[0].length || x < 0 || y < 0 || arr[x][y] != word.charAt(step)) {
            return false;
        }
        char temp = arr[x][y];
        arr[x][y] = ' ';
        boolean res = dfs(arr, word, x + 1, y, step + 1) ||
                dfs(arr, word, x, y + 1, step + 1) ||
                dfs(arr, word, x - 1, y, step + 1) ||
                dfs(arr, word, x, y - 1, step + 1);

        arr[x][y] = temp;
        return res;
    }

}

