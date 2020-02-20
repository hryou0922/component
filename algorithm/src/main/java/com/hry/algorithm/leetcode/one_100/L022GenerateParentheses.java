package com.hry.algorithm.leetcode.one_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 *  https://leetcode.com/problems/generate-parentheses/
 *
 *  深度搜索解法：
 *      针对一个长度为2n的合法排列，第1到2n个位置都满足如下规则：左括号的个数大于等于右括号的个数。
 *          假设在位置k我们还剩余left个左括号和right个右括号，
 *              如果left>0，则我们可以直接打印左括号
 *              如果left < right && right >=0，则我们不能打印右括号
 *              如果left和right均为零，则说明我们已经完成一个合法排列，可以将其打印出来。
 *
 *  解法：
 *      https://juejin.im/post/5a3b7c585188257d72429abf  深度搜索图
 *      https://www.jianshu.com/p/c53527084798 算法
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/12/4 9:40
 */
public class L022GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> rtnList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        // 左边括号剩余数量
        int left = n-1;
        // 右边括号剩余数量
        int right = n;

        sb.append("(");
        re(left, right, sb, rtnList);

        return rtnList;
    }

    /**
     *
     * @param left 左边括号数量
     * @param right 右边括号剩余数量
     * @param sb
     */
    private void re(int left, int right, StringBuilder sb, List<String> rtnList) {
        System.out.println(left + " " + right + " " + sb.toString());
        // 结束条件
        if(left == 0 && right == 0){
            rtnList.add(sb.toString());
            return;
        }
        if(left > 0){
            sb.append("(");
            re(left-1, right, sb, rtnList);
            sb.deleteCharAt(sb.length()-1);
        }

        // 左括号必须大于等于右括号
        if(right > 0 && left < right){
            sb.append(")");
            re(left, right-1, sb, rtnList);
            sb.deleteCharAt(sb.length()-1);
        }

    }

}
