package com.css.mdemo.leetcode.stringtest;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0)return "";
        if (strs.length==1)return strs[0];
        int minLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minLength) minLength = strs[i].length();
        }
        int count = 0;
        for (int i = 0; i < minLength; i++) {
            for (int j = 0; j < strs.length-1; j++) {
                if (strs[j].charAt(i)!=strs[j+1].charAt(i)){
                    return strs[0].substring(0,count);
                }
            }
            count++;
        }
        return strs[0].substring(0,count);
    }
}
