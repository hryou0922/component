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
 * @author: huangrongyou@yixin.im
 * @date: 2019/8/15
 */
public class NQueen {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     *    List<List<String>>:
     *      里面一层List表示一种解法：一个String表示一行的排列，个数等于n
     *          List<String>：使用索引存储行row值，使用值存储列column值
     *
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }

        search(results, new ArrayList<Integer>(), n);
        return results;
    }

    /**
     * 递归方法
     * @param results 存在以及解出来的解
     * @param cols 存储当前正在处理的中间解
     * @param n
     */
    private void search(List<List<String>> results,
                        List<Integer> cols,
                        int n) {
        if (cols.size() == n) {
            // 此时保存值成功，保存以及解出来的解，并返回
            results.add(drawChessboard(cols));
            return;
        }

        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!isValid(cols, colIndex)) {
                continue;
            }
            // 如果值符合要求，则加入到列表
            cols.add(colIndex);
            // 搜索下一个符合条件的值
            search(results, cols, n);
            // 清除上一个值，回退到上一步，再进行判断
            cols.remove(cols.size() - 1);
        }
    }

    private List<String> drawChessboard(List<Integer> cols) {
        List<String> chessboard = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                sb.append(j == cols.get(i) ? 'Q' : '.');
            }
            chessboard.add(sb.toString());
        }
        return chessboard;
    }

    /**
     * 		一个皇后q(x,y)能被满足以下条件的皇后q(row,col)吃掉
     * 			1. x=row(在纵向不能有两个皇后)
     * 			2. y=col（横向）
     * 			3. col + row = y+x;（斜向正方向）
     *          4. col - row = y-x;（斜向反方向）
     *
     * @param cols
     * @param column
     * @return
     */
    private boolean isValid(List<Integer> cols, int column) {
        int row = cols.size();
        for (int rowIndex = 0; rowIndex < cols.size(); rowIndex++) {
            if (cols.get(rowIndex) == column) {
                return false;
            }
            if (rowIndex + cols.get(rowIndex) == row + column) {
                return false;
            }
            if (rowIndex - cols.get(rowIndex) == row - column) {
                return false;
            }
        }
        return true;
    }
}
