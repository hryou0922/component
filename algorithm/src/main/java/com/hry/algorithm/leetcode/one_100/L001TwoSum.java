package com.hry.algorithm.leetcode.one_100;

import java.util.HashMap;

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
    /**
     * 方法二， hashmap O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_2(int[] nums, int target) {
        int[] rtn = new int[]{-1,-1};
        if(nums == null || nums.length < 2){
            return rtn;
        }

        // value - index
        HashMap<Integer,Integer> numMap = new HashMap<>(nums.length);
        // 用hashmap保存访问过的value, 对每个num[i],检查hashmap中是否有target - nums[i],扫完一遍就能够得到结果。属于用空间换时间。
        for(int i = 0; i < nums.length; i++){
            // 要查找的目标值: / 对于每一个element nums[i], 在数组中找是否存在target - nums[i]
            int targetValue = target - nums[i];

            Integer targetIndex = numMap.get(targetValue);
            if(targetIndex != null){
                rtn[0] = i;
                rtn[1] = targetIndex;
            }

            numMap.put(nums[i], i);
        }
        return rtn;
    }

    public int[] twoSum_1(int[] nums, int target) {
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
