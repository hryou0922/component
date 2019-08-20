package com.hry.algorithm.recursive;


import org.junit.Test;

import java.util.List;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2019/8/15 11:23
 */
public class NQueenTest {
    @Test
    public void test(){
        int n = 8;
        NQueen nQueen = new NQueen();
        List<List<String>> queenList = nQueen.solveNQueens(n);
        int index = 0;
        for(List<String> strList : queenList){
            System.out.println("index = " + index++);
            for(String str : strList){
                System.out.println(str);
            }
        }
    }

    @Test
    public void test3(){
        int n = 1;
        BitNQueenII nQueen = new BitNQueenII();
        System.out.println(nQueen.totalNQueens(n));
    }

    @Test
    public void test2(){
        int n = 8;
        NQueenII nQueenII = new NQueenII();
        int num = nQueenII.totalNQueens(n);
        System.out.println(num);
    }
}
