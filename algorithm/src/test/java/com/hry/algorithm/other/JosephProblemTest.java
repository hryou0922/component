package com.hry.algorithm.other;

import org.junit.Test;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2019/8/16 9:34
 */
public class JosephProblemTest {

    @Test
    public void test(){
        JosephProblem josephProblem = new JosephProblem();
        int n = 6;
        int k = 5;
        System.out.println(josephProblem.josephProblem(n, k));
    }
}
