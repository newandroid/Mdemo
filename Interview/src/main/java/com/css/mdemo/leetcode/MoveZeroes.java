package com.css.mdemo.leetcode;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums.length < 2) return;
        int endFlag = nums.length;
        for (int i = 0; i < endFlag; i++) {
            while (nums[i] == 0&&endFlag>1) {
                for (int j = i; j < endFlag-1; j++) {
                    nums[j]=nums[j+1];
                    nums[j+1]=0;
                }
                endFlag--;
            }
        }
        for (int i : nums) {
            System.out.printf("" + i + ",");
        }
    }
}
