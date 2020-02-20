package com.hry.algorithm.leetcode.one_100;

/**
 * 12. Integer to Roman
 *  https://leetcode.com/problems/integer-to-roman/
 *
 *  官方推荐：
 *      public String intToRoman(int num) {
 *         int[] data = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
 *         String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
 *         StringBuilder ans = new StringBuilder();
 *         for(int i = 0; i < data.length; i++) {
 *             while(num >= data[i]) {
 *                 num -= data[i];
 *                 ans.append(roman[i]);
 *             }
 *         }
 *         return ans.toString();
 *     }
 *
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

        int count = 0;
        while(num > 0){
            int tmp = num % 10;
            if(tmp > 0) {
                if (count == 0) {
                    sb.insert(0,ones[tmp-1]);
                }else if(count == 1){
                    sb.insert(0,tens[tmp-1]);
                }else if(count == 2){
                    sb.insert(0,hundreds[tmp-1]);
                }else {
                    sb.insert(0,thousands[tmp-1]);
                }
            }
            num = num / 10;
            count++;
        }

        return sb.toString();
    }
}
