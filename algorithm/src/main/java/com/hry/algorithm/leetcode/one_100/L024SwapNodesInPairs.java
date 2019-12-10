package com.hry.algorithm.leetcode.one_100;

import static com.hry.algorithm.leetcode.one_100.L021MergeTwoSortedLists.ListNode;

/**
 * 24. Swap Nodes in Pairs
 *  https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/12/10 19:21
 */
public class L024SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode newHeader = new ListNode(-1);

        ListNode tail = newHeader;

        while(head != null && head.next != null){
            // 下一个循环的节点：必须执行此操作，否则会出现循环
            ListNode tmp = head.next.next;

            // 后一个节点
            tail.next = head.next;
            tail = tail.next;
            // 前一个节点
            tail.next = head;
            tail = tail.next;
            // 跳到后面2个
            head = tmp;
        }
        tail.next = head == null ? null : (head.next == null ? head : head.next);

        return newHeader.next;
    }

}
