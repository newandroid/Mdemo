package com.css.mdemo.leetcode;

/**
 * Created by css on 2018/7/18.
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
//        return mySolution(nums);
        return answerSolution(nums);
    }

    public int mySolution(int[] nums) {
        int j = nums.length;
        if (j <= 0) return 0;
        if (j == 1) return 1;
        for (int i = 0; i < j - 1; i++) {
            while (nums[i] == nums[i + 1] && j > 1 && (i < j - 1)) {
                j--;
                for (int k = i + 1; k < j; k++) {
                    nums[k] = nums[k + 1];
                }
            }
        }
        return j;
    }

    public int answerSolution(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
