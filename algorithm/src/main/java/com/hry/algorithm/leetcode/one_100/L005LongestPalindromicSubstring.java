package com.hry.algorithm.leetcode.one_100;

/**
 *  最长回文子串
 *  5. Longest Palindromic Substring
 *      https://leetcode.com/problems/longest-palindromic-substring/
 *
 *  算法：
 *      https://blog.csdn.net/u013309870/article/details/70742315
 *      https://wizardforcel.gitbooks.io/the-art-of-programming-by-july/content/01.05.html
 *
 *    最长回文子串——Manacher 算法：
 *      https://segmentfault.com/a/1190000003914228
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/10/29 20:02
 */
public class L005LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if(s == null){
            return s;
        }
        // 从第0个字符开始，每个字符向左右两边扩展，判断是否是回文。考虑回文是偶数和奇数情况

        // 最大的长度
        int max = 0;
        // 最大长度回文索引起始值
        int maxBeginIndex = 0;
        // 最大长度回文索引结束值
        int maxEndIndex = 0;

        for(int i = 0; i < s.length(); i++){
            // 奇数回文：边界（左边索引>0，右边<length）

            for(int j = 0; (i-j)>=0 && (i+j)<s.length(); j++){
                // 两边的需要相同：第0次是 索引 0,0 的比较
                if(s.charAt(i-j) != s.charAt(i+j)){
                    break;
                }
                int maxTmp = 2 * j + 1;
                if(maxTmp > max){
                    max = maxTmp;
                    maxBeginIndex = i - j;
                    maxEndIndex = i + j;
                }
            }


            // 偶数回文
            for(int j = 0; i-j >= 0 && (i+j+1)< s.length(); j++){
                // 两边的需要相同：第0次是 索引 0,1 的比较
                if(s.charAt(i-j) != s.charAt(i+j+1)){
                    break;
                }
                int maxTmp = 2 * j + 2;
                if(maxTmp > max){
                    max = maxTmp;
                    maxBeginIndex = i - j;
                    maxEndIndex = i + j + 1;
                }
            }
        }
        // 由于返回： beginIndex - (endIndex-1)
        return s.substring(maxBeginIndex, (maxEndIndex +1) > s.length() ? s.length() : (maxEndIndex +1) );
    }
}
