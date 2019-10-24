package com.hry.algorithm.leetcode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 *  感觉这道题目有问题，解法里要保证2个列表的长度相同，但是题目里没有说明
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/10/23 11:21
 */
public class AddTwoNumbers {
    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}
