package com.css.mdemo.leetcode.linklist;

import com.css.mdemo.leetcode.basedatastruct.ListNode;

public class MergeTwoLists {
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1==null)return l2;
        if (l2==null)return l1;
        ListNode result = null;
        if (l1.val<l2.val){
            result = l1;
            result.next = merge(l1.next,l2);
        }else {
            result = l2;
            result.next = merge(l1,l2.next);
        }
        return result;
    }
}
