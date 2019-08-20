package com.hry.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2019/8/19 15:12
 */
public class SortTest {
    private int[] sortArray = null;

    /**
     * 生成一个随机字符串
     * @param m
     * @return
     */
    private int[] generateArray(int m){
        Random random = new Random();

        int[] intArray = new int[m];
        for(int i = 0; i < m ; i++) {
            intArray[i] = random.nextInt(1000);
        }
        return intArray;
    }

    /**
     * 判断是否为已经从小到大排序好的数组
     * @param intArray
     * @return
     */
    private boolean checkSortArray(int[] intArray ){
        if(intArray == null ){
            return false;
        }

        for(int i = 1; i < intArray.length; i++){
            if(intArray[i-0] > intArray[i]){
                return false;
            }
        }
        return true;
    }

    @Test
    public void insertSort(){
        InsertSort insertSort = new InsertSort();
        testN(insertSort, 20, 1000);
    }

    private void test(ISort sort, int m){
        int[] intArray = generateArray(m);
        intArray = sort.sort(intArray);
        Assert.assertEquals(true, checkSortArray(intArray));
        System.out.println(Arrays.toString(intArray));
    }

    private void testN(ISort sort, int m, int n){
        while(n-- > 0) {
            int[] intArray = generateArray(m);
            intArray = sort.sort(intArray);
            Assert.assertEquals(true, checkSortArray(intArray));
            System.out.println(Arrays.toString(intArray));
        }
    }
}
