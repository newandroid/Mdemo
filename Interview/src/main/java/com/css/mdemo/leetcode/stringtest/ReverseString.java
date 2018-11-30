package com.css.mdemo.leetcode.stringtest;

public class ReverseString {
    public String reverseString(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = s.length()-1; i >=0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
