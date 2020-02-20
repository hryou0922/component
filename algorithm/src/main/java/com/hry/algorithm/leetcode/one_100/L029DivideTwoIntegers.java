package com.hry.algorithm.leetcode.one_100;

/**
 * 29. Divide Two Integers
 *
 *  https://leetcode.com/problems/divide-two-integers/
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/12/12 19:59
 */
public class L029DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        // Integer.MAX_VALUE: 2147483647 0x7fffffff
        // Integer.MIN_VALUE: 2147483648 0x80000000
        System.out.println(Integer.MAX_VALUE + " " + Integer.MIN_VALUE);

        long dividendLong = dividend;
        // -2147483648 -1
        int sign = 1;
        if(dividendLong * dividend < 0){
            sign = -1;
        }
        long rtn = dividendLong / divisor * sign;
        if(rtn > Integer.MAX_VALUE || rtn < Integer.MIN_VALUE){
            rtn = Integer.MAX_VALUE;
        }
        return (int)rtn;
    }
}
