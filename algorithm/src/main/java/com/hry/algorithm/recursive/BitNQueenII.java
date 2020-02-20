package com.hry.algorithm.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * n皇后问题是将n个皇后放置在n*n的棋盘上，皇后彼此之间不能相互攻击。
 *
 * 给定一个整数n，返回所有不同的n皇后问题的解决方案。
 *
 * 每个解决方案包含一个明确的n皇后放置布局，其中“Q”和“.”分别表示一个女王和一个空位置。
 *
 * 来源：https://www.jiuzhang.com/solution/n-queens/
 *
 * bit位的解法，速度极快：
 *      https://zhuanlan.zhihu.com/p/35269271
 * @author: huangrongyou@yixin.im
 * @date: 2019/8/15
 */
public class BitNQueenII {
    private int N = 8; // 皇后数量，可拓展为N皇后
    private  int count = 0; // 总方法数
    private  int limit;

    public int totalNQueens(int n) {
        N = n;
        limit = (1 << N) - 1;
        backtracking(0, 0, 0, 0);
        return count;
    }

    private void backtracking(int a, int b, int c, int depth) {
        if (depth == N) {
            count++;
            return;
        }
        int d = a | b | c;
        while (d < limit) {
            int bit = (d + 1) & ~d;
            backtracking(a | bit, limit & ((b | bit) >> 1), limit & ((c | bit) << 1), depth + 1);
            d |= bit;
        }
    }
}
