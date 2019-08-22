package com.hry.algorithm.sort;

/**
 *  选择排序(Selection sortArray)也是一种简单直观的排序算法。
 *  - 直接选择排序
 *
 *  算法步骤：
 *  1）首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
 *  2）再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 *  3）重复第二步，直到所有元素均排序完毕。
 * @author: huangrongyou@yixin.im
 * @date: 2019/8/19
 */
public class SelectionSort implements ISort {
    @Override
    public int[] sortArray(int[] intArray) {
        if(intArray == null || intArray.length == 0){
            return intArray;
        }

        // 从索引0开始选择，直至倒数第二个，判断哪个索引是最小值，并填写到索引0位置上，依次类推，最后一个索引不需要操作
        for(int i = 0; i < intArray.length -1 ; i++){
            // 最小值的索引
            int min = i;
            // 从索引i+1 开始，找出最小的值
            for(int j = i+1; j < intArray.length; j++){
                if(intArray[j] < intArray[min]){
                    min = j;
                }
            }

            if(min != i){
                // 如果发生变化，则进行交换
                swap(intArray, min ,i);
            }
        }

        return intArray;
    }

    private void swap(int[] intArray, int min, int i) {
        int tmp = intArray[min];
        intArray[min] = intArray[i];
        intArray[i] = tmp;
    }
}
