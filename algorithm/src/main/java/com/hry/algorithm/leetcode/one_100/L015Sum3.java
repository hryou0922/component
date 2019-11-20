package com.hry.algorithm.leetcode.one_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 *  https://leetcode.com/problems/3sum/
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/11/19 19:55
 */
public class L015Sum3 {

    /**
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum_1(int[] nums) {
        List<List<Integer>> rtnList = new ArrayList<>();

        if(nums == null || nums.length < 3){
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

                        if(!rtnList.contains(oneRow)){
                            rtnList.add(oneRow);
                        }
                    }
                }
            }
        }


        return rtnList;
    }
}
