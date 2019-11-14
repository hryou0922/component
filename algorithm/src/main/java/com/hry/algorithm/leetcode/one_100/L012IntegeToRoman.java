package com.hry.algorithm.leetcode.one_100;

/**
 * 12. Integer to Roman
 *  https://leetcode.com/problems/integer-to-roman/
 * @author: huangrongyou@yixin.im
 * @date: 2019/11/14 20:08
 */
public class L012IntegeToRoman {

    // 个位: 1-9
    private String[] ones = {"I","II", "III", "IV", "V", "VI", "VII","VIII", "IX"};
    // 十位: 10,20,...90
    private String[] tens = {"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    // 百位: 100,200,.. 900
    private String[] hundreds = {"C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    // 千位: 1000,2000,3000
    private String[] thousands = {"M", "MM", "MMM"};

    public String intToRoman(int num) {
        if( num < 1 && num > 3999){
            return "";
        }
        StringBuilder sb = new StringBuilder();


        return sb.toString();
    }
}
