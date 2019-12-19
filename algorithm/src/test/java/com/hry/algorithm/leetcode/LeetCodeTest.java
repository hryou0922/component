package com.hry.algorithm.leetcode;

import com.hry.algorithm.leetcode.one_100.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2019/10/22 19:50
 */
public class LeetCodeTest {

    @Test
    public void L001TwoSum(){
        L001TwoSum l001TwoSum = new L001TwoSum();
   //     Assert.assertArrayEquals(new int[]{0,1}, l001TwoSum.twoSum_2(new int[]{2, 7, 11, 15}, 9));
    //    Assert.assertArrayEquals(new int[]{1,2}, l001TwoSum.twoSum_2(new int[]{3,2,4}, 6));
        l001TwoSum.twoSum_2(new int[]{3,2,4}, 6);
        System.out.println(Arrays.toString(l001TwoSum.twoSum_2(new int[]{2,7,11,15}, 9)));

    }

    @Test
    public void longestSubstringWithoutRepeatingCharacters(){
        String testStr1 = "abcabcbb";
        String testStr2 = "pwwkew";
        String testStr3 = "abba";
        L003LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new L003LongestSubstringWithoutRepeatingCharacters();
        // 方法1
        Assert.assertEquals(3, longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring1(testStr1));
        Assert.assertEquals(3, longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring1(testStr2));
        Assert.assertEquals(2, longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring1(testStr3));

        // 方法2
        Assert.assertEquals(3, longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring2(testStr1));
        Assert.assertEquals(3, longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring2(testStr2));
        Assert.assertEquals(2, longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring2(testStr3));

    }

    @Test
    public void medianOfTwoSortedArrays(){
        int[] nums1 = new int[]{1, 3};
        int[] nums2 =  new int[]{2};

        L004MedianOfTwoSortedArrays medianOfTwoSortedArrays = new L004MedianOfTwoSortedArrays();
        Assert.assertEquals(2.0, medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2), 0);


        nums1 = new int[]{1, 2};
        nums2 =  new int[]{3, 4};
        Assert.assertEquals(2.5, medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2), 0);
    }

    @Test
    public void LongestPalindromicSubstring(){
        L005LongestPalindromicSubstring longestPalindromicSubstring = new L005LongestPalindromicSubstring();
        Assert.assertEquals("bab", longestPalindromicSubstring.longestPalindrome("babad"));
    }

    @Test
    public void L007ReverseInteger(){
        L007ReverseInteger l007ReverseInteger = new L007ReverseInteger();
        Assert.assertEquals(321, l007ReverseInteger.reverse(123));
        Assert.assertEquals(-54321, l007ReverseInteger.reverse(-12345));
        Assert.assertEquals(0, l007ReverseInteger.reverse(1534236469));
    }


    @Test
    public void L008StringToInteger(){
        L008StringToInteger l008StringToInteger = new L008StringToInteger();
        Assert.assertEquals(42, l008StringToInteger.myAtoi("42"));
        Assert.assertEquals(-42, l008StringToInteger.myAtoi("   -42"));
        Assert.assertEquals(4193, l008StringToInteger.myAtoi("4193 with words"));
        Assert.assertEquals(0, l008StringToInteger.myAtoi("words and 987"));
        Assert.assertEquals(-2147483648, l008StringToInteger.myAtoi("-91283472332"));
        Assert.assertEquals(2147483647, l008StringToInteger.myAtoi("9223372036854775808"));
    }

    @Test
    public void L009PalindromeNumber(){
        L009PalindromeNumber l009PalindromeNumber = new L009PalindromeNumber();

        Assert.assertEquals(true, l009PalindromeNumber.isPalindrome(0));
        Assert.assertEquals(true, l009PalindromeNumber.isPalindrome(11));
        Assert.assertEquals(true, l009PalindromeNumber.isPalindrome(121));
        Assert.assertEquals(false, l009PalindromeNumber.isPalindrome(-121));
        Assert.assertEquals(false, l009PalindromeNumber.isPalindrome(10));
    }

    @Test
    public void L012IntegeToRoman(){
        L012IntegeToRoman l012IntegeToRoman = new L012IntegeToRoman();

        Assert.assertEquals("III", l012IntegeToRoman.intToRoman(3));
        Assert.assertEquals("IV", l012IntegeToRoman.intToRoman(4));
        Assert.assertEquals("IX", l012IntegeToRoman.intToRoman(9));
        Assert.assertEquals("LVIII", l012IntegeToRoman.intToRoman(58));
        Assert.assertEquals("MCMXCIV", l012IntegeToRoman.intToRoman(1994));
    }

    @Test
    public void L015Sum3(){
        L015Sum3 l015Sum3 = new L015Sum3();
        System.out.println(l015Sum3.threeSum_2(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(l015Sum3.threeSum_2(new int[]{0,0,0,0}));
        // [[-1,-1,2],[-1,0,1]]
        System.out.println(l015Sum3.threeSum_2(new int[]{ -1,0,1,2,-1,-4}));
    }

    @Test
    public void L017LetterCombinationsofaPhoneNumber() {
        L017LetterCombinationsofaPhoneNumber l017LetterCombinationsofaPhoneNumber = new L017LetterCombinationsofaPhoneNumber();

        System.out.println(l017LetterCombinationsofaPhoneNumber.letterCombinations("23"));


        System.out.println(l017LetterCombinationsofaPhoneNumber.letterCombinations2("23"));


    }

    @Test
    public void L020ValidParentheses(){
        L020ValidParentheses l020ValidParentheses = new L020ValidParentheses();

        Assert.assertEquals(true, l020ValidParentheses.isValid("()"));
        Assert.assertEquals(true, l020ValidParentheses.isValid("()[]{}"));
        Assert.assertEquals(false, l020ValidParentheses.isValid("(]"));
        Assert.assertEquals(false, l020ValidParentheses.isValid("([)]"));
        Assert.assertEquals(true, l020ValidParentheses.isValid("{[]}"));
    }

    @Test
    public void L021MergeTwoSortedLists() {
        L021MergeTwoSortedLists.ListNode l1 = new L021MergeTwoSortedLists.ListNode(4, null);
        L021MergeTwoSortedLists.ListNode l1_2 = new L021MergeTwoSortedLists.ListNode(2, l1);
        L021MergeTwoSortedLists.ListNode l1_3 = new L021MergeTwoSortedLists.ListNode(1, l1_2);

        L021MergeTwoSortedLists.ListNode l2 = new L021MergeTwoSortedLists.ListNode(4, null);
        L021MergeTwoSortedLists.ListNode l2_2 = new L021MergeTwoSortedLists.ListNode(3, l2);
        L021MergeTwoSortedLists.ListNode l2_3 = new L021MergeTwoSortedLists.ListNode(1, l2_2);

        L021MergeTwoSortedLists l021MergeTwoSortedLists = new L021MergeTwoSortedLists();
        L021MergeTwoSortedLists.ListNode rtnList = l021MergeTwoSortedLists.mergeTwoLists_2(l1_3, l2_3);
        while(rtnList != null){
            System.out.print(rtnList.getVal()+ "　");
            rtnList = rtnList.getNext();
        }


        rtnList = l021MergeTwoSortedLists.mergeTwoLists(l1_3, l2_3);
        while(rtnList != null){
            System.out.print(rtnList.getVal());
            rtnList = rtnList.getNext();
        }


    }
    @Test
    public void L021MergeTwoSortedLists2() {
        L021MergeTwoSortedLists.ListNode l1 = new L021MergeTwoSortedLists.ListNode(4, null);
        L021MergeTwoSortedLists.ListNode l1_2 = new L021MergeTwoSortedLists.ListNode(2, l1);
        L021MergeTwoSortedLists.ListNode l1_3 = new L021MergeTwoSortedLists.ListNode(1, l1_2);

        L021MergeTwoSortedLists.ListNode l2 = new L021MergeTwoSortedLists.ListNode(4, null);
        L021MergeTwoSortedLists.ListNode l2_2 = new L021MergeTwoSortedLists.ListNode(3, l2);
        L021MergeTwoSortedLists.ListNode l2_3 = new L021MergeTwoSortedLists.ListNode(1, l2_2);

        L021MergeTwoSortedLists l021MergeTwoSortedLists = new L021MergeTwoSortedLists();

        L021MergeTwoSortedLists.ListNode rtnList = l021MergeTwoSortedLists.mergeTwoLists(l1_3, l2_3);
        while(rtnList != null){
            System.out.print(rtnList.getVal() + " ");
            rtnList = rtnList.getNext();
        }
    }

    @Test
    public void L022GenerateParentheses(){
        L022GenerateParentheses l022GenerateParentheses = new L022GenerateParentheses();
        System.out.println(l022GenerateParentheses.generateParenthesis(3));
    }


    @Test
    public void L024SwapNodesInPairs() {
        L021MergeTwoSortedLists.ListNode l1 = new L021MergeTwoSortedLists.ListNode(4, null);
        L021MergeTwoSortedLists.ListNode l1_2 = new L021MergeTwoSortedLists.ListNode(2, l1);
        L021MergeTwoSortedLists.ListNode l1_3 = new L021MergeTwoSortedLists.ListNode(1, l1_2);

        L024SwapNodesInPairs l024SwapNodesInPairs = new L024SwapNodesInPairs();

        L021MergeTwoSortedLists.ListNode rtnList = l024SwapNodesInPairs.swapPairs(l1_3);
        while(rtnList != null){
            System.out.print(rtnList.getVal() + " ");
            rtnList = rtnList.getNext();
        }
    }

    @Test
    public void L027RemoveElement(){
        L027RemoveElement l027RemoveElement = new L027RemoveElement();
        int[] nums = new int[]{3,2,2,3};
        int val = 3;
        System.out.println(l027RemoveElement.removeElement(nums, val));
    }

    @Test
    public void L029DivideTwoIntegers(){
        L029DivideTwoIntegers l029DivideTwoIntegers = new L029DivideTwoIntegers();

        Assert.assertEquals(3, l029DivideTwoIntegers.divide(10, 3));
    }

    @Test
    public void L032LongestValidParentheses(){
        L032LongestValidParentheses l032LongestValidParentheses = new L032LongestValidParentheses();

        Assert.assertEquals(2, l032LongestValidParentheses.longestValidParentheses("(()"));
        Assert.assertEquals(4, l032LongestValidParentheses.longestValidParentheses(")()())"));
        Assert.assertEquals(4, l032LongestValidParentheses.longestValidParentheses(")()())()()("));
    }


}






















