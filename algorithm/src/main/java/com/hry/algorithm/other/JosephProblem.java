package com.hry.algorithm.other;

/**
 *
 * n个人按顺序围成一圈(编号为1~n),从第1个人从1开始报数，报到k的人出列，相邻的下个人重新从1开始报数，报到k的人出列，重复这个过程，直到队伍中只有1个人为止，这就是约瑟夫问题。现在给定n和k，你需要返回最后剩下的那个人的编号。
 * 在线评测地址: http://www.lintcode.com/problem/joseph-problem/
 *
 * 约瑟夫问题是个有名的问题：N个人围成一圈，从第一个开始报数，第M个将被杀掉，最后剩下一个，其余人都将被杀掉。例如N=6，M=5，被杀掉的人的序号为5，4，6，2，3。最后剩下1号。
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/8/15 17:44
 */
public class JosephProblem {


    class node{
        int id;
        node next;
        node(int id){
            this.id = id;
            this.next = null;
        }
    }

    /**
     * @param n: an integer
     * @param k: an integer
     * @return: the last person's number
     */
    public int josephProblem(int n, int k) {
        // 创建一个循环列表
        node head = new node(1);
        node cur = head;
        for(int i = 2; i <= n; i++) {
            node nx = new node(i);
            cur.next = nx;
            cur = cur.next;
        }
        cur.next = head;


        int sum = 0;
        while(true) {
            // 循环次数为k-1次，不是k次： cur值是要删除节点的前一个
            for(int i = 0; i < k - 1; i++) {
                cur = cur.next;
            }
            System.out.println("delete " + cur.next.id);
            // 跳过cur.next的值
            cur.next = cur.next.next;
            // 循环次数加1
            sum++;
            // 当循环测试达到n-1，即
            if(sum == n - 1) {
                break;
            }
        }
        return cur.id;
    }

}
