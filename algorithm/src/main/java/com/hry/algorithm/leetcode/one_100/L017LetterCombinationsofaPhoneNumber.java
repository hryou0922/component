package com.hry.algorithm.leetcode.one_100;

import java.util.LinkedList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 *  https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 *  这个问题我们可以采用递归的思路来进行解决，首先看第1个数字，我们可以通过对应的表来知道第1个数字对应的字母可能有哪些，那么此时只需要知道剩下的l-1(l是数字串长度)可能代表的字符串有哪些，然后将第1个数字对应的字母与这些字符串两两拼接起来，便可以得到所有可能的解。
 *
 *  方法1：
 *      方法1 非backtracking方法，用for循环来做
 *          https://segmentfault.com/a/1190000013632638
 *  方法2：
 *      递归
 *          https://segmentfault.com/a/1190000003766442
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/11/22 14:44
 */
public class L017LetterCombinationsofaPhoneNumber {
    // 号码和字符关系
    private String[] mapping = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};



    public List<String> letterCombinations(String digits) {
        LinkedList<String> rtnList = new LinkedList<>();

        if(digits == null && digits.length() == 0){
            return rtnList;
        }
        StringBuilder sb = new StringBuilder();
        helper(digits,0, sb, rtnList);
        return rtnList;
    }

    /**
     * 递归操作
     * @param digits 处理字符串
     * @param idx 本次递归处理的字符索引
     * @param sb 已经生产字符组
     * @param rtnLis 保存生成的列表
     */
    private void helper(String digits, int idx, StringBuilder sb, LinkedList<String> rtnLis){

        if(digits.length() == idx){
            // 递归结束: 处理完最后一个元素，再添加
            if(sb.length() != 0){
                rtnLis.add(sb.toString());
            }
        }else {
            // 找出当前位数字对应可能的字母
            String candidates = mapping[digits.charAt(idx) - '0'];
            for(char ch : candidates.toCharArray()){
                // 添加字符
                sb.append(ch);
                // 处理下一个字符
                helper(digits, idx+1, sb, rtnLis);
                // 删除刚刚添加的字符
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    /**
     *
     * 这道题就是一种排列组合，对于一种按键组合我们要按照输入顺序排列组合出所有的字符串。
     * 每一次按键我们都会得到一系列字符串，如"2"得到"a","b","c"。这将成为下一次操作的前序字符串。
     * 我们将字符串存储在linkedlist里面，通过peek操作依次取出前序字符串。对于每一个不同的前序字符串，我们都要在其后面分别加上当前键所表示的不同字符，再将获得的结果字符串加入linkedlist里面
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations2(String digits) {
        LinkedList<String> res = new LinkedList<String>();
        if(digits.length() == 0){
            return res;
        }
        res.add("");

        for(int i=0;i<digits.length();i++){
            int index = Character.getNumericValue(digits.charAt(i));
            // 本次去除的字符长度 == i
            while(res.peek().length() == i){
                String temp = res.remove();
                for(char c : mapping[index].toCharArray()){
                    res.add(temp+c);
                }
            }
        }

        return res;
    }

//    private void recursive(String digits, int startIndex, List<String> rtnList){
//
//        if(startIndex == digits.length() -1){
//            char charTmp = digits.charAt(startIndex);
//            rtnList.add(charTmp - '0' - 1)
//            return;
//        }
//
//    }


}
