package com.hry.algorithm.sort;

/**
 * 希尔排序是希尔（Donald Shell）
 *  直接插入排序算法的高级版本
 *  图解：https://www.cnblogs.com/chengxiao/p/6104371.html
 *
 *  希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/8/22 16:57
 */
public class ShellSort implements ISort {

    @Override
    public int[] sortArray(int[] intArray) {
        if(intArray == null || intArray.length == 0){
            return intArray;
        }

        // 增量序列：每次循环是之前的1/2
        for(int i = intArray.length/2; i > 0; i = i/2){
            // 根据增量值，本次被分成了i组，需要对每个组都循环一遍
            for(int j = 0; j < i; j++){
                // 每组的第一个元素索引
                int firstIndex = j;
                // 每组的两个元素的相关值
                int gap = i;
                // 对每个组执行插入算法，组的间变成i; 共需要循环
                for(int m = firstIndex + gap; m < intArray.length; m += gap){
                    int sortValue = intArray[m];
                    // 将sortValue插入到已经排好的左边队列中，从后向前找
                    for(int n = m - gap; n >= firstIndex; n-=gap){
                        if(sortValue > intArray[n]){
                            intArray[n+gap] = sortValue;
                            break;
                        }else {
                            intArray[n+gap]  = intArray[n];
                            if(n == firstIndex){
                                intArray[firstIndex] = sortValue;
                            }
                        }
                    }
                }
            }
        }
        return intArray;
    }
}
