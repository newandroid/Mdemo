package com.css.mdemo.leetcode;

/**
 * Created by css on 2018/7/18.
 */
public class Robber {
    // TODO: 2018/7/18 没做完，这个是不对的
    public int rob(int[] nums) {//error
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int oddSum = 0;
        int evenSum = 0;
        if (nums.length % 2 == 0) {
            for (int i = 0; i < nums.length; i++) {
                if (i % 2 == 0) {
                    evenSum += nums[i];
                } else {
                    oddSum += nums[i];
                }
            }
        } else {
            for (int i = 1; i < nums.length - 1; i++) {
                if (i % 2 == 0) {
                    evenSum += nums[i];
                } else {
                    oddSum += nums[i];
                }
            }
        }
        return Math.max(oddSum, evenSum);
    }
}
