package com.hry.algorithm.leetcode.one_100;

/**
 * 9. Palindrome Number
 *  https://leetcode.com/problems/palindrome-number/
 *
 *
 *  官方的方法：
 *        public boolean isPalindrome(int x) {
 *          // 处理特殊值 <0; 0 < n < 10
 *         if (x == 0) return true;
 *         if (x < 0 || x % 10 == 0) return false;
 *         // 从int个位值开始重新生成一个新值，直至 新值 <= 处理过的x
 *         int reverse = 0;
 *         while (x > reverse) {
 *             reverse = reverse * 10 + x % 10;
 *             x /= 10;
 *         }
 *         return reverse == x || reverse/10 == x;
 *      }
 *
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/11/7 13:44
 */
public class L009PalindromeNumber {


    public boolean isPalindrome(int x) {
        // 值小于等于0根据不是回文
        if(x < 0){
            return false;
        }
        if(x < 10){
            return true;
        }
        // 返回int值的长度
        int strLength = stringSize(x);
        // int 拆分存储的数组
        int[] intArray = new int[strLength];

        int index = 0;
        while( x > 0){
            intArray[index++] = x % 10;
            x = x / 10;
        }
        // 检查数组是否为回文
        int leftIndex = 0;
        int rightIndex = intArray.length-1;

        boolean isPalindrome = false;
        while(intArray[leftIndex++] == intArray[rightIndex--]){
            // 回文结束：左右索引值相同或左右值正好交叉过一个，则表示是回文
           if(leftIndex == rightIndex
            || leftIndex - rightIndex == 1){
               isPalindrome = true;
               break;
           }
        }
        return isPalindrome;
    }

    final int [] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE };

    /**
     * 返回int值的长度
     * @param x
     * @return
     */
    int stringSize(int x) {
        for (int i=0; ; i++) {
            if (x <= sizeTable[i]) {
                return i + 1;
            }
        }
    }
}
