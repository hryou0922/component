package com.hry.algorithm.leetcode.one_100;

/**
 *  28. Implement strStr()
 *      未真正实现
 *
 *  https://leetcode.com/problems/implement-strstr/
 *
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/12/12 19:48
 */
public class L028ImplementStr {

    // 直接使用 string 的 indexOf 方法
//    public int strStr(String haystack, String needle) {
//        return haystack.indexOf(needle);
//    }

    public int strStr(String haystack, String needle) {
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();

        for(int i = 0; i < haystackArray.length; i++){
            char tmp = haystackArray[i];

        }
        return -1;
    }

}
