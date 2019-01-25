package com.css.mdemo.leetcode.linklist;

public class ReverseLinkList {
    public static class MLinkList {
        int val;
        MLinkList next;

        public MLinkList(int val) {
            this.val = val;
        }
    }

    public MLinkList reverseLinkList(MLinkList list) {
//        return iterative(list);
        return recursive(list, null);
    }

    public MLinkList iterative(MLinkList list) {//迭代的方式
        MLinkList newList = null;
        while (list != null) {
            MLinkList node = list.next;
            list.next = newList;
            newList = list;
            list = node;
        }
        return newList;
    }

    public MLinkList recursive(MLinkList list, MLinkList newList) {
        if (list == null)
            return newList;
        MLinkList node = list.next;
        list.next = newList;
        newList = list;
        return recursive(node, newList);
    }
}
