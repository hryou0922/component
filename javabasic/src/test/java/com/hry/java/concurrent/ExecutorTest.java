package com.hry.java.concurrent;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by huangrongyou@yixin.im on 2018/4/24.
 */
public class ExecutorTest {

    @Test
    public void isTerminatedTest() throws InterruptedException {

        // 测试 isTerminated
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.shutdown();
        System.out.println(executorService.isTerminated());
        Thread.sleep(10 * 1000);
        System.out.println(executorService.isTerminated());
    }

    @Test
    public void invokeAllTest() throws InterruptedException {
        List<Callable<Object>> callableList = new ArrayList<>();
        callableList.add(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(2 * 1000);
                return "";
            }
        });
        // 测试 invokeAll
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        List<Future<Object>> futureList = executorService.invokeAll(callableList, 1, TimeUnit.SECONDS);
        futureList.stream().forEach((o)-> System.out.println(o.isDone() + "|" + o.isCancelled()));
    }

}
