package com.hry.algorithm.sort;

/**
 * 直接插入排序
 *  插入排序是一种最简单直观的排序算法，它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/8/19
 */
public class InsertSort implements ISort {

    @Override
    public int[] sortArray(int[] intArray){
        if(intArray == null || intArray.length == 0){
            return intArray;
        }

        // 索引号为 1 - (length-1) 参与到和已经排序的队列进行排序
        for(int i = 1; i < intArray.length; i++){
            // 待排序值
            int sortValue = intArray[i];
            // 排序的值要和自己前面的所有数字比较，从后面开始比较，数字大的数字排在后面，索引范围为 (i-1)-0
            for(int k = i-1; k >=0; k--){
                // 如果比较的数字大，则存储在当前数字的后面；否则当前数字后移一位
                if(sortValue > intArray[k]){
                    intArray[k+1] = sortValue;
                    break;
                }else {
                    intArray[k+1] = intArray[k];
                    // 临界值 0
                    if(k == 0){
                        intArray[0] = sortValue;
                    }
                }
            }
        }

        return intArray;
    }

}
