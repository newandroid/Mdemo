package com.css.mdemo.leetcode;

/**
 * Created by css on 2018/7/19.
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] - prices[i] > 0) {
                sum += (prices[i + 1] - prices[i]);
            }
        }
        return sum;
    }
}
