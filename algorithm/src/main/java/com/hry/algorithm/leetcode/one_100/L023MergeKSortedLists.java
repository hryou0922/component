package com.hry.algorithm.leetcode.one_100;


import java.util.PriorityQueue;

import static com.hry.algorithm.leetcode.one_100.L021MergeTwoSortedLists.ListNode;
/**
 * 23. Merge k Sorted Lists
 *  https://leetcode.com/problems/merge-k-sorted-lists/
 *
 *  解法一：
 *      PriorityQueue
 *  解法二：
 *      分治法：sort + merge
 *      略不同于递归方法，递归只有一个方法
 *      https://zhuanlan.zhihu.com/p/33050219
 *
 *      --> 引申 归并排序
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/12/5 18:56
 */
public class L023MergeKSortedLists {


    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return sort(lists, 0, lists.length - 1);
    }

    public ListNode sort(ListNode[] lists, int lo, int hi) {
        if (lo>= hi) return lists[lo];
        int mid = (hi - lo) /2 + lo;
        ListNode l1 = sort(lists, lo, mid);
        ListNode l2 = sort(lists, mid+1, hi);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode header = new ListNode(-1);

        ListNode tail = header;
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
        tail.next = l1 == null ? l2 : l1;

        return header.next;
    }

//    /**
//     * 两个队列合并 - 递归可以使用，但是看不懂
//     * @param l1
//     * @param l2
//     * @return
//     */
//    public ListNode merge(ListNode l1, ListNode l2) {
//        if (l1 == null) return l2;
//        if (l2 == null) return l1;
//        if (l1.val < l2.val) {
//            l1.next = merge(l1.next, l2);
//            return l1;
//        }
//        l2.next = merge(l1, l2.next);
//        return l2;
//    }

    /**
     * 通过 PriorityQueue 队列处理
     * @param lists
     * @return
     */
    public ListNode mergeKListsByPriorityQueue(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val -b.val);// 重写了compare函数，按照链表们的头部进行升序排序Override the compare function, sort by the head of the lists in ascending order


        ListNode forEach = null;
        for(ListNode listNode : lists){
            forEach = listNode;
            while(forEach != null){
                ListNode tmp = forEach;
                queue.add(tmp);
                forEach = forEach.next;
                tmp.next = null;
            }
        }

        ListNode header = new ListNode(0);
        ListNode cur = header;
        while (! queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
        }
        return header.next;
    }

}
