package com.hry.algorithm.leetcode.one_100;

/**
 * 从数组中选出两个数，这两个数加起来的值等于目标值，返回这两个数的索引
 *
 * 1. Two Sum
 *  https://leetcode.com/problems/two-sum/
 *
 *  改进方法：
 *      1. 第一个使用轮询方式，查找第二个使用hash提高第二次查找速度
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/10/22 19:42
 */
public class L001TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] rtn = new int[]{-1,-1};
        // 不含尾巴
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    rtn[0] = i;
                    rtn[1] = j;
                    break;
                }
            }
        }
        return rtn;
    }
}
