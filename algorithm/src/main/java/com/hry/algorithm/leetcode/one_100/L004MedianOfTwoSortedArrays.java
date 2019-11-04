package com.hry.algorithm.leetcode.one_100;

/**
 *  4. Median of Two Sorted Arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/10/29 18:54
 */
public class L004MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        // 如果总数为双数，则中间值为 total/2, total/2+1; 如果总数为单数，则中间值为 total/2
        int mid0 = total / 2;
        int mid1 = total%2 == 0 ? mid0-1 : mid0;

        int[] mergeNums = new int[total];

        // 数组索引从0开始
        int numIndex1 = 0;
        int numIndex2 = 0;
        // 合并数组索引
        int mergeIndex = 0;

        // 2个队列同时处理
        while(numIndex1 < nums1.length && numIndex2 < nums2.length){
            if(nums1[numIndex1] < nums2[numIndex2]){
                mergeNums[mergeIndex++] = nums1[numIndex1++];
            }else {
                mergeNums[mergeIndex++] = nums2[numIndex2++];
            }
        }
        // 处理第一个队列，第一个队列还有记录
        while (numIndex1 < nums1.length){
            mergeNums[mergeIndex++] = nums1[numIndex1++];
        }

        // 处理第二个队列
        while (numIndex2 < nums2.length){
            mergeNums[mergeIndex++] = nums2[numIndex2++];
        }

        return (mergeNums[mid0] + mergeNums[mid1])/2.0;
    }
}
