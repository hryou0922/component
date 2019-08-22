package com.hry.algorithm.sort;

/**
 *  冒泡排序（Bubble Sort）: 越大的元素会经由交换慢慢“浮”到数列的顶端
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/8/22 16:37
 */
public class BubbleSort implements ISort {

    @Override
    public int[] sortArray(int[] intArray) {
        if(intArray == null || intArray.length == 0){
            return intArray;
        }
        // 索引从0开始执行比较，最后一个元素不需要执行比较
        for(int i = 0; i < intArray.length-1; i++){
            for(int j = 0; j < intArray.length -1 - i; j++){
                if(intArray[j] > intArray[j+1]){
                    swap(intArray, j, j+1);
                }
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
