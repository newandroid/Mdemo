package com.css.mdemo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        //row
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char wait = board[i][j];
                if (wait != '.' && set.contains(wait)) return false;
                else set.add(wait);
            }
        }

        //Column
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char wait = board[j][i];
                if (wait != '.' && set.contains(wait)) return false;
                else set.add(wait);
            }
        }

        //3*3
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Set<Character> set = new HashSet<>();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        char wait = board[i*3+k][j*3+l];
                        if (wait != '.' && set.contains(wait)) return false;
                        else set.add(wait);
                    }
                }
            }
        }

        return true;

    }
}
