package com.hry.algorithm.sort;

import java.util.Arrays;

/**
 * 基数排序(radix sort)又称桶排序（bucket sort）
 *  基数排序(radix sort)属于"分配式排序"(distribution sort)，又称"桶子法"(bucket sort)或bin sort，顾名思义，它是透过键值的部份资讯，将要排序的元素分配至某些"桶"中，藉以达到排序的作用，基数排序法是属于稳定性的排序，其时间复杂度为O (nlog(r)m)，其中r为所采取的基数，而m为堆数，在某些时候，基数排序法的效率高于其它的稳定性排序法。
 *
 *  https://www.cnblogs.com/developerY/p/3172379.html
 *
 *  https://segmentfault.com/a/1190000013986116
 *
 *  这个算法只支持正整数
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/9/12 17:36
 */
public class RadixSort implements ISort{

    @Override
    public int[] sortArray(int[] intArray) {
        if(intArray == null || intArray.length == 0){
            return intArray;
        }

        // 比数组中所有数组都大的数
        int maxNum = getMaxArray(intArray);
        // 桶的个数
        int bucketNum = 10;
        // 创建10个桶
        int[][] bucketArray = new int[bucketNum][intArray.length];
        // 创建一个保存每个桶已有的数字，初始化值为0
        int[] bucketIndexArray = new int[bucketNum];
        Arrays.fill(bucketIndexArray, 0);

        // 位数：从第0位开始
        int bitNum = 1;
        while(bitNum < maxNum){
            // 将数组中的每个数字放到对应的桶中
            for(int i = 0; i < intArray.length; i++){
                // 当前桶的位数
                int digit = (intArray[i]/bitNum)%10;
                // 将数放置到 digit桶，索引为bucketNum[digit]，并将下一个桶的索引加1
                bucketArray[digit][bucketIndexArray[digit]++] = intArray[i];
            }
            // 将所有桶中的数据重排，存入列表
            int oldArrayIndex = 0;
               // 外层循环，桶
               for(int j = 0; j < bucketNum; j++){
                   // 如果桶里面的数字为0，则直接跳过
                   if(bucketIndexArray[j] != 0){
                       // 每个桶存储到列表中
                       for(int k = 0; k < bucketIndexArray[j]; k++){
                           intArray[oldArrayIndex++] = bucketArray[j][k];
                       }
                       // 将桶的计数器为0
                       bucketIndexArray[j] = 0;
                   }
               }

            // 循环到下一位
            bitNum *= 10;

        }

        return intArray;
    }

    /**
     * 获取最大的值
     * @param intArray
     * @return
     */
    private int getMaxArray(int[] intArray) {
        int max = intArray[0];
        for(int num : intArray){
            if(num > max){
                max = num;
            }
        }
        return max;
    }

}
