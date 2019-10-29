package com.hry.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2019/10/22 19:50
 */
public class LeetCodeTest {

    @Test
    public void twoSum(){

    }

    @Test
    public void longestSubstringWithoutRepeatingCharacters(){
        String testStr1 = "abcabcbb";
        String testStr2 = "pwwkew";
        String testStr3 = "abba";
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
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

        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        Assert.assertEquals(2.0, medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2), 0);


        nums1 = new int[]{1, 2};
        nums2 =  new int[]{3, 4};
        Assert.assertEquals(2.5, medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2), 0);


    }
}
