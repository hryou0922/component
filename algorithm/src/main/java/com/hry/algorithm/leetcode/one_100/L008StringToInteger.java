package com.hry.algorithm.leetcode.one_100;

/**
 * 8. String to Integer (atoi)
 *  https://leetcode.com/problems/string-to-integer-atoi/
 *
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/11/4 10:36
 */
public class L008StringToInteger {

    public int myAtoi(String str) {
        // 返回值，使用long值，避免溢出。long 还是不够，还可以只可能超过long
        long rtn = 0;

        // 符号
        int sign = 1;

        if(str != null){
            // 第一个字符已经处理
            boolean firstFind = false;

            for(int i = 0; i < str.length(); i++){
                char tmpChar = str.charAt(i);

                // 首字符处理
                if(!firstFind){
                    // 空格字节跳过
                    if(' ' == tmpChar){
                        continue;
                    }else if('+' == tmpChar){ // 符号：+
                        sign = 1;
                        firstFind = true;
                        continue;
                    }else if('-' == tmpChar){ // 符号：-
                        sign = -1;
                        firstFind = true;
                        continue;
                    }
                }

                // 通过上面的机制 continue 机制，到了这里保证后面只有数字是正确的，其他都是错误，立即结束
                // 数字：0,9
                if('0' <= tmpChar && tmpChar <= '9' ){
                    rtn = rtn * 10 + (tmpChar - '0');
                    firstFind = true;
                    // long 还是不够，还可以只可能超过long
                    if(rtn * sign >= Integer.MAX_VALUE){
                        rtn = Integer.MAX_VALUE;
                        break;
                    }else if(rtn * sign <= Integer.MIN_VALUE){
                        rtn = Integer.MIN_VALUE;
                        break;
                    }
                }else {
                    break;
                }

            }
        }
        rtn = rtn * sign;
        return (int) rtn;
    }
}
