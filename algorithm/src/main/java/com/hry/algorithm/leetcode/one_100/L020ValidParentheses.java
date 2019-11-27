package com.hry.algorithm.leetcode.one_100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 *  20. Valid Parentheses
 *  https://leetcode.com/problems/valid-parentheses/
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/11/26 19:27
 */
public class L020ValidParentheses {

    public boolean isValid(String s) {
        boolean isValid = true;

        Map<Character, Character> map = new HashMap<>(3);
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        // LinkedList 做为 堆栈使用，新进后出： addFirst, poll
        LinkedList<Character> stackList = new LinkedList<>();
        for(char ch : s.toCharArray()){
            Character valueChar = map.get(ch);
            if(valueChar != null) {
                // 如果从map中找到，则表示是左括号。添加到列表中，
                stackList.addFirst(ch);
            }else {
                // 如果map中没有找到，则表示右括号
                // 从列表中弹出第一个值，并获取此对应的右括号，比较两者是否相同
                Character stackReal = map.get(stackList.poll());
                if(stackReal == null || stackReal.charValue() != ch){
                    isValid = false;
                    break;
                }

            }
        }
        // 合法的值比较完，列表为空
        if(stackList.size() != 0){
            isValid = false;
        }

        return isValid;
    }

}
