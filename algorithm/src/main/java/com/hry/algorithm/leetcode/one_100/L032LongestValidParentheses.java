package com.hry.algorithm.leetcode.one_100;

import java.util.ArrayDeque;

/**
 * 32. Longest Valid Parentheses
 *  https://leetcode.com/problems/longest-valid-parentheses/
 *
 *  解法：
 *      https://blog.csdn.net/koala_tree/article/details/81385559
 *      https://www.cnblogs.com/grandyang/p/4424731.html
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/12/13 9:42
 */
public class L032LongestValidParentheses {

    /**
     * 借助栈来求解，需要定义个 start 变量来记录合法括号串的起始位置，遍历字符串，
     *  如果遇到左括号，则将当前下标压入栈，
     *  如果遇到右括号，如果当前栈为空，则将下一个坐标位置记录到 start，
     *      如果栈不为空，则将栈顶元素取出，
     *      此时若栈为空，则 maxLength 和 i - start + 1 中的较大值，否则更新结果和 i - st.top() 中的较大值
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        // 最大长度
        int maxLength = 0;
        // 记录字符串的起始位置
        int start = 0;

        // 当做堆栈使用：存储字符的索引号
        ArrayDeque<Integer> stack = new ArrayDeque<>(s.length());
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                // 如果遇到左括号，则将当前下标压入栈
                stack.push(i);
            }else {
                // 如果遇到右括号
                if(stack.isEmpty()){
                    // 如果当前栈为空，则将下一个坐标位置记录到 start。此时右括号没有对应的左括号匹配
                    start = i + 1;
                }else {
                    // 栈顶弹出
                    stack.pop();
                    if(stack.isEmpty()){
                        // 当做括号为空，此时的确定长度起始值为start。当出现“）”且没有“(”时，start才变
                        // 这里考虑这种情况 ()()
                        maxLength = max(maxLength, i - start + 1);
                    }else {
                        // 当括号为空，此时的可确定最长度为起始值为 (stack顶-1)
                        // 这里考虑这种情况: (())
                        maxLength = max(maxLength, i - stack.peek());
                    }
                }
            }
        }
        return maxLength;
    }

    /**
     * 改进版本
     *  stack 的第一个进去的值为-1，替代start值
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        // 最大长度
        int maxLength = 0;

        // 当做堆栈使用：存储字符的索引号
        ArrayDeque<Integer> stack = new ArrayDeque<>(s.length());
        stack.push(-1);

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                // 如果遇到左括号，则将当前下标压入栈
                stack.push(i);
            }else {
                stack.pop();
                if(!stack.isEmpty()){
                    maxLength = max(maxLength, i - stack.peek());
                }else {
                    stack.push(i);
                }
            }
        }
        return maxLength;
    }

    private int max(int a, int b){
        return  a > b ? a : b;
    }

}
