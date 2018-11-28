package com.css.mdemo;

import com.css.mdemo.leetcode.MaxProfit;
import com.css.mdemo.leetcode.RemoveElements;

import org.junit.Test;

/**
 * Created by css on 2018/7/19.
 */
public class LeetCodeTest {
    @Test
    public void test() {

        String line = "[7,1,5,3,6,4]";
        int[] nums = stringToIntegerArray(line);

        int ret = new MaxProfit().maxProfit(nums);
//        String out = integerArrayToString(nums, ret);

        System.out.print(ret);
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    @Test
    public void testleedcode() {
        RemoveElements removeElements = new RemoveElements();
        RemoveElements.ListNode listNode = removeElements.new ListNode(1);
        RemoveElements.ListNode last = removeElements.removeElements(listNode, 1);
        while (last != null) {
            System.out.println(last.val);
            last = last.next;
        }

    }
}
