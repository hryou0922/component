package com.hry.algorithm.leetcode.one_100;

/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/11/27 17:27
 */
public class L021MergeTwoSortedLists {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }

        public ListNode(int x) {
            val = x;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 创建头，这里是关键
        ListNode headerNode = new ListNode(-1);

        ListNode tail = headerNode;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;
            }else {
                tail.next = l2;
                tail = tail.next;
                l2 = l2.next;
            }
        }
        tail.next = (l1 == null ? l2 : l1);
        // 返回header
        return headerNode.next;
    }
    public ListNode mergeTwoLists_2(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        // 这里不要使用next替换，会有奇怪的问题
        // 确定头节点：特殊处理
        ListNode header = null;
        if(l1.val < l2.val){
            header = new ListNode(l1.val);
            l1 = l1.next;
        }else {
            header = new ListNode(l2.val);
            l2 = l2.next;
        }
        // 尾节点
        ListNode tail = header;


        // 两个相互比较，直至其中一个列表空了
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                ListNode tmpNode = new ListNode(l1.val);
                tail.next = tmpNode;
                tail = tmpNode;
                l1 = l1.next;
            }else {
                ListNode tmpNode = new ListNode(l2.val);
                tail.next = tmpNode;
                tail = tmpNode;
                l2 = l2.next;
            }
        }
        // l1 未处理完
        if(l1 != null){
            tail.next = l1;
        }

        // l2 未处理完
        if(l2 != null){
            tail.next = l2;
        }

        return header;
    }
}
