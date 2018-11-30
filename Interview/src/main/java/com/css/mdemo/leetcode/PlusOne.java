package com.css.mdemo.leetcode;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 > 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                break;
            }
        }

        if (digits[0]==0){
            int[] result = new int[digits.length+1];
            result[0]=1;
            return result;

        }else
        return digits;
    }
}
