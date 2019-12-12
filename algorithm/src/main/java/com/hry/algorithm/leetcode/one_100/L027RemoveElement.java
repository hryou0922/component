package com.hry.algorithm.leetcode.one_100;

/**
 * 27. Remove Element
 *  https://leetcode.com/problems/remove-element/
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/12/10 20:00
 */
public class L027RemoveElement {

    public int removeElement(int[] nums, int val) {
        // 双指针
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while(leftIndex <= rightIndex){
            // 如果相等， 和最右边交换数值，右指针左移
            if(nums[leftIndex] == val){
                swap(nums, leftIndex, rightIndex);
                rightIndex--;
            }else {
                leftIndex++;

            }
        }
        return leftIndex;
    }

    private void swap(int[] nums, int leftIndex, int rightIndex) {
        int tmp = nums[leftIndex];
        nums[leftIndex] = nums[rightIndex];
        nums[rightIndex] = tmp;
    }

}
