package com.hry.guava;

public class MyThreadUtils {

    /**
     * 睡眠ns
     * @param sencond
     */
    public static void sleepSencond(long sencond){
        try {
            Thread.sleep(sencond * 1000L );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 休息毫秒数
     * @param millis
     */
    public static void sleepMillis(long millis){
        try {
            Thread.sleep(millis );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
