package com.hry.guava.concurrent;

import com.google.common.util.concurrent.RateLimiter;
import com.hry.guava.MyThreadUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 限流使用RateLimiter
 */
public class RateLimiterUtils {

    /**
     * 测试限流的用法
     */
    public static void useRateLimiter(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // 创建限流，每秒10个
        RateLimiter rateLimiter = RateLimiter.create(10);

        // 计数
        AtomicInteger num = new AtomicInteger(0);
        executorService.execute(() -> {
            while (true && !Thread.currentThread().isInterrupted()) {
                // 如果获取成功，则执行后续请求
                rateLimiter.acquire();
                System.out.println(num.incrementAndGet());
                MyThreadUtils.sleepMillis(10);
            }
        });
        MyThreadUtils.sleepSencond(10);
        System.out.println("预期达到100，实际达到" + num.get());
    }
}
