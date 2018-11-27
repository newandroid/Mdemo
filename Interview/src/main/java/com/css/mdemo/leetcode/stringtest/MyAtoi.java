package com.css.mdemo.leetcode.stringtest;

public class MyAtoi {
    public int myAtoi(String str) {
        str = str.trim();
        int index = 0;
        int sign = 1;
        int total = 0;
        //empty
        if (str.length() == 0) return 0;

        // space
        while (index < str.length() && str.charAt(index) == ' ') index++;

        // + -
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9) break;
            if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            total = total * 10 + digit;
            index++;
        }
        return sign * total;
    }
}
