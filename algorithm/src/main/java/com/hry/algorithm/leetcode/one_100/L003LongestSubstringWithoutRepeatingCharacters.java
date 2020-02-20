package com.hry.algorithm.leetcode.one_100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * 3. Longest Substring Without Repeating Characters
 *  https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * 例子：
 *  https://blog.csdn.net/liuchonge/article/details/62046271
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/10/23 11:35
 */
public class L003LongestSubstringWithoutRepeatingCharacters {



    /**
     * 使用map来保存每个字符的索引位置信息，然后引入j游标记录字符串左边的起始位置，遍历索引i相当于其右边结束位置
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if(s == null){
            return 0;
        }
        // 记录最值
        int max = 0;
        // 字符 - 字符最后出现的位置
        HashMap<Character, Integer> hashMap = new HashMap<>();
        // j:统计字符串的起始位置
        for(int i =0, j = 0; i < s.length(); i++){
            char tmpChar = s.charAt(i);
            if(hashMap.containsKey(tmpChar)){
                // 已经存在的逻辑，更新j值
                // 注意这里一定要将j赋值为 j 和 map.get(s.charAt(i))+1二者中较大的一个：如果之前tmpChar的索引比j小，则表示此tmpChar已经不在计算字符串中，当前tmpChar可以被加入到待计算字符串中
                j = Math.max(j,hashMap.get(tmpChar)+1);
            }
            // 替换值，并重新计算最大值
            hashMap.put(tmpChar, i);
            max = Math.max(max, i-j + 1);
        }
        return max;
    }

    /**
     * 最简单的版本， O(n2)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        if(s == null){
            return 0;
        }
        // 记录最大长度
        int max = 0;

        Set<Character> hasSet = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            // 清空
            hasSet.clear();
            for(int j = i; j < s.length(); j++){
                // 找到重复的元素或字符串遍历结束，则进行最大值统计
                if(!hasSet.add(s.charAt(j))
                        || j == s.length()-1){
                    // 如果已经存在，则
                    if(max < hasSet.size()){
                        max = hasSet.size();
                    }
                    // 此循环结束
                    break;
                }
            }
        }
        return max;
    }

}
