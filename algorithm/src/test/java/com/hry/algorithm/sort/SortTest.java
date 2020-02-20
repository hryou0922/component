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
            intArray[i] = random.nextInt(100);
        }
        return intArray;
    }

    /**
     * 判断是否为已经从小到大排序好的数组
     * @param intArray
     * @return
     */
    private boolean checkSortArray(int[] oldArray, int[] intArray ){
        if(intArray == null ){
            return false;
        }
        // 新旧数组值长度相同
        if(oldArray.length != intArray.length){
            return false;
        }
        // 对老的数组进行排序
        Arrays.sort(oldArray);

        // 顺序是否正确
        for(int i = 0; i < intArray.length; i++){
            if(oldArray[i] != intArray[i]){
                return false;
            }
        }
        return true;
    }

    @Test
    public void insertSort2() {
        int[] a = {2,0};

        // oldArray
        int[] oldArray = new int[a.length];
        System.arraycopy(a, 0, oldArray, 0, a.length);

        InsertSort insertSort = new InsertSort();
        System.out.println(Arrays.toString(insertSort.sortArray(a)));
        Assert.assertEquals(true, checkSortArray(oldArray, a));

    }
    @Test
    public void insertSort(){
        InsertSort insertSort = new InsertSort();
        testN(insertSort, 20, 1000);
    }

    @Test
    public void selectionSort(){
        SelectionSort selectionSort = new SelectionSort();
        testN(selectionSort, 20, 1000);
    }

    @Test
    public void bubbleSort(){
        BubbleSort bubbleSort = new BubbleSort();
        testN(bubbleSort, 20, 1000);
    }

    @Test
    public void shellSort(){
        ShellSort shellSort = new ShellSort();
        testN(shellSort, 20, 1000);
    }

    @Test
    public void heapSort(){
        HeapSort shellSort = new HeapSort();
 //       testN(shellSort, 20, 1000);
        test(shellSort, 20);
    }

    @Test
    public void quickSort(){
        QuickSort quickSort = new QuickSort();
        //       testN(shellSort, 20, 1000);
        testN(quickSort, 20,1000);
    }

    @Test
    public void mergeSort(){
        MergeSort mergeSort = new MergeSort();
        // test(mergeSort, 20);
         testN(mergeSort, 20,1000);
    }

    @Test
    public void radixSort(){
        RadixSort radixSort = new RadixSort();
        // test(mergeSort, 20);
        testN(radixSort, 20, 1000);
    }

    @Test
    public void radixSort2(){
        RadixSort radixSort = new RadixSort();
        // test(mergeSort, 20);
        testN(radixSort, 20, 1000);
    }


    private void test(ISort sort, int m){
        int[] intArray = generateArray(m);
        System.out.println("排序前记录" + Arrays.toString(intArray));
        intArray = sort.sortArray(intArray);
        // oldArray
        int[] oldArray = new int[intArray.length];
        System.arraycopy(intArray, 0, oldArray, 0, intArray.length);
        System.out.println(Arrays.toString(intArray));
        Assert.assertEquals(true, checkSortArray(oldArray, intArray));

    }

    private void testN(ISort sort, int m, int n){
        while(n-- > 0) {
            int[] intArray = generateArray(m);
            intArray = sort.sortArray(intArray);
            // oldArray
            int[] oldArray = new int[intArray.length];
            System.arraycopy(intArray, 0, oldArray, 0, intArray.length);
            Assert.assertEquals(true, checkSortArray(oldArray, intArray));
            System.out.println(Arrays.toString(intArray));
        }
    }
}
