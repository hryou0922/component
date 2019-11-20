package com.hry.algorithm.leetcode.one_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/11/19 19:55
 */
public class L015Sum3 {

    /**
     * 方法二：sort + 双指针
     * 3sum = one + 2sum
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum_2(int[] nums) {
        List<List<Integer>> rtnList = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return rtnList;
        }

        // 必须进行排序: 后面的列表相同比较才有意义
        Arrays.sort(nums);

        // 将3sum 转化为 one + 2sum，其中2sum = target - one
        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过重复记录
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = 0 - nums[i];
            sum2(nums, i, target, rtnList);
        }

        return rtnList;
    }

    private void sum2(int[] nums, int beginIndex, int target, List<List<Integer>> rtnList) {
        // sum2起始数据
        int start = beginIndex + 1;
        int oldStart = start;
        int end = nums.length - 1;
        // 对于已经排序好的记录，使用双指针
        while (start < end) {
            // 跳过重复记录:左边
            if (start != oldStart && nums[start] == nums[start - 1]) {
                start++;
                continue;
            }
            // 跳过重复记录:右边
            if (end != nums.length - 1 && nums[end] == nums[end + 1]) {
                end--;
                continue;
            }

            int sumTmp = nums[start] + nums[end];
            if (sumTmp == target) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[beginIndex]);
                list.add(nums[start]);
                list.add(nums[end]);
                rtnList.add(list);

                start++;
            } else if (sumTmp < target) {
                // 比目标值小，则左边加1
                start++;
            } else {
                // 比目标值小，则右边加1
                end--;
            }
        }
    }

    /**
     * 穷举法：暴力破解
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum_1(int[] nums) {
        List<List<Integer>> rtnList = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return rtnList;
        }
        // 必须进行排序: 后面的列表相同比较才有意义
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> oneRow = new ArrayList<>();
                        oneRow.add(nums[i]);
                        oneRow.add(nums[j]);
                        oneRow.add(nums[k]);

                        if (!rtnList.contains(oneRow)) {
                            rtnList.add(oneRow);
                        }
                    }
                }
            }
        }


        return rtnList;
    }
}
