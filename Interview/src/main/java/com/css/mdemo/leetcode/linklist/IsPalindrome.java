package com.css.mdemo.leetcode.linklist;

import com.css.mdemo.leetcode.basedatastruct.ListNode;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head){
        StringBuffer sb = new StringBuffer();
        while (head!=null){
            sb.append(""+head.val);
            head = head.next;
        }
        if (sb.toString().equals(sb.reverse().toString()))return true;else return false;
    }
}
