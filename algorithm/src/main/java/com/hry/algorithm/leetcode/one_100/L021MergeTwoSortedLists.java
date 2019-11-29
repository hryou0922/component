package com.hry.algorithm.leetcode.one_100;

/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/11/27 17:27
 */
public class L021MergeTwoSortedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        // 确定头节点：特殊处理
        ListNode header = null;
        if(l1.val < l2.val){
            header = l1;
        }else {
            header = l2;
        }
        // 尾节点
        ListNode tail = header;


        // 两个相互比较，直至其中一个列表空了
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
