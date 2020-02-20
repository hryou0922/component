package com.hry.algorithm.sort;

import java.util.Arrays;

/**
 *  归并排序
 *
 * https://www.cnblogs.com/chengxiao/p/6194356.html
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/9/12 15:11
 */
public class MergeSort implements ISort {
    @Override
    public int[] sortArray(int[] intArray) {
        if(intArray == null || intArray.length == 0){
            return intArray;
        }
        int[] tmpArray = new int[intArray.length];

        sort(intArray, 0, intArray.length-1, tmpArray);

        return intArray;
    }

    /**
     * 排序
     * @param intArray 待排序数组
     * @param left 开始索引
     * @param right 结束索引，不是长度
     * @param tmpArray 中间临时数组
     */
    private void sort(int[] intArray, int left, int right, int[] tmpArray){
        if(left < right){
            int mid = (left + right)/2;
            sort(intArray, left, mid, tmpArray);
            sort(intArray, mid+1, right, tmpArray);
            // 进行组合
            merge(intArray, left, mid, right, tmpArray);
        }
    }

    /**
     * 两个数组进行合并操作
     * @param intArray 待排序数据
     * @param left 左边索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param tmpArray 临时数组
     */
    private void merge(int[] intArray, int left, int mid, int right, int[] tmpArray) {
        int leftIndex = left;
        int rightIndex = mid + 1;
        int tmpArrayIndex = left;
        // 两个数组都不为空
        while(leftIndex <= mid && rightIndex <= right){
            if(intArray[leftIndex] < intArray[rightIndex]){
                tmpArray[tmpArrayIndex++] = intArray[leftIndex++];
            }else {
                tmpArray[tmpArrayIndex++] = intArray[rightIndex++];
            }
        }
        // 左边数组不空，右边空了
        while(leftIndex <= mid){
            tmpArray[tmpArrayIndex++] = intArray[leftIndex++];
        }
        // 右边数据不空，左边空了
        while(rightIndex <= right){
            tmpArray[tmpArrayIndex++] = intArray[rightIndex++];
        }

        // 将临时数组拷贝到正式数组中
        tmpArrayIndex = left;
        while(tmpArrayIndex <= right){
            intArray[tmpArrayIndex] = tmpArray[tmpArrayIndex];
            tmpArrayIndex++;
        }

    }

}

















