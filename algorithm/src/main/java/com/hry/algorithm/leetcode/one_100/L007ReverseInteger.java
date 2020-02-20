package com.hry.algorithm.leetcode.one_100;

/**
 * 7 Reverse Integer
 *
 *      https://leetcode.com/problems/reverse-integer/
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/11/4 10:02
 */
public class L007ReverseInteger {

    public int reverse(int x) {
        // 根据符号确定初始值
        int sign = 1;
        if(x < 0){
            sign = -1;
            // 将负数转化为整数
            x = 0 - x;
        }

        // 从低位到高位逐个获取值：考虑到溢出的情况，必须使用long类型
        long rtn = 0;
        while(x > 0){
            // 获取最低位值
            int tmpLow = x % 10;
            rtn = rtn * 10 + tmpLow;
            // 准备下一个循环数据
            x = x/10;
        }
        // 增加对0溢出的判断
        long tmpRtn = sign * rtn;
        if(tmpRtn <= Integer.MAX_VALUE && tmpRtn >= Integer.MIN_VALUE){
            return (int)tmpRtn;
        }else {
            return 0;
        }
    }

}
