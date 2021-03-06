package com.css.mdemo.leetcode;

import com.css.mdemo.leetcode.basedatastruct.ListNode;

public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode headNode = head;
        ListNode cursorNode = head;
        while (cursorNode != null && cursorNode.val == val) {
            headNode = cursorNode.next;
            cursorNode = cursorNode.next;
        }

        while (cursorNode != null && cursorNode.next != null) {
            if (cursorNode.next.val == val) {
                cursorNode.next = cursorNode.next.next;
            } else {
                cursorNode = cursorNode.next;
            }
        }
        return headNode;
    }

}
