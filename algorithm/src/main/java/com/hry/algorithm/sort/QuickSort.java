package com.hry.algorithm.sort;


import java.util.Arrays;

/**
 *
 * 快速排序：
 *  1. 选择一个值作为哨兵，算法有：第0个，中间那个，随机值
 *  2. 从左边开始循环，直至找到一个比哨兵大的值；切换到从右边开始查找，直到比哨兵小的值；将这两个值交换，并将对应的索引加1和减1
 *  3. 重复以上步骤，直至两个值相碰
 *  4. 递归 quickSort(start, j); quickSort(i, end)
 *
 *  https://blog.csdn.net/IT_ZJYANG/article/details/53406764
 *      这个更清楚一些
 *
 *  http://logy-bai.github.io/algorithm/2015/07/23/quick-sort/
 *
 *  https://my.oschina.net/albert2011/blog/785604
 *      这个不是特别好，容易误导
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/9/9 11:13
 */
public class QuickSort implements ISort {

    @Override
    public int[] sortArray(int[] intArray) {

        if(intArray == null || intArray.length == 0){
            return intArray;
        }
        quickSort(intArray, 0, intArray.length-1);

        return intArray;
    }

    /**
     * 快排
     * @param intArray
     * @param startIndex 最左边的索引
     * @param endIndex  最右边的索引
     */
    private void quickSort(int[] intArray, int startIndex, int endIndex){
        if(startIndex >= endIndex){
            return;
        }
        // 哨兵索引
        int guardIndex = startIndex;
        int guardValue = intArray[startIndex];
        // 左边的索引
        int leftIndex = startIndex;
        // 右边的索引
        int rightIndex = endIndex;

        // 支持等于，当等于时，执行索引加减后，左右索引正好错开，正好分成两个待排序数组
        while(leftIndex <= rightIndex ) {
            // 左边向右边走: 不能越界；左边的值大于哨兵，不能等于
            while( (leftIndex <= rightIndex) && intArray[leftIndex] < guardValue){
                leftIndex++;
            }

            // 右边向左边走：不能越界；右边的值大于哨兵，不能等于
            while( (rightIndex >= leftIndex) &&  (intArray[rightIndex] > guardValue) ){
                rightIndex--;
            }

            // 交换后索引要变化
            if(leftIndex <= rightIndex){
                swap(intArray, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }

        }

        System.out.println("guard=" + guardValue + " " + startIndex + " - " + endIndex + " " + Arrays.toString(intArray) + " leftIndex = " + leftIndex);

        // 左边部分在排序：因为上面当两边相碰时，再执行索引加减后，左右索引正好错开
        quickSort(intArray, startIndex, rightIndex);
        // 右边部分再排序：同左边说明
        quickSort(intArray, leftIndex, endIndex);
    }

    private void swap(int[] intArray, int min, int i) {
        int tmp = intArray[min];
        intArray[min] = intArray[i];
        intArray[i] = tmp;
    }
}
