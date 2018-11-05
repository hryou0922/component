package com.hry.java.lambda;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class StreamsEffectivenessDemo {

    /**
     * 串行Stream执行时间
     * @param values
     */
    public void executeStream(List<String> values){
        // 串行排序：
        long t0 = System.nanoTime();
        long count = values.stream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
        // 串行耗时: 872 ms
    }

    /**
     * 并行Stream执行时间
     * @param values
     */
    public void executeParallelStream(List<String> values){
        // 串行排序：
        long t0 = System.nanoTime();
        long count = values.parallelStream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("parallel  sort took: %d ms", millis));
        // 并行耗时: 459 ms
    }

}
