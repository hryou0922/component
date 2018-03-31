package com.hry.component.javabasic.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class SemaphoreTest {
    private Semaphore semaphore = new Semaphore(3);

    public void execute(){
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<String> inputArrayList = new ArrayList<String>();
        for(int i = 0; i < 100; i++){
            inputArrayList.add(""+i);
        }

        for(String o : inputArrayList){
            try{
                System.out.println("可用资源：" + semaphore.availablePermits());
                semaphore.acquire();

                executorService.execute(new SimpleRunable(o));
                // 通过countDownLatch保证，一次最多N个线程同时运行
            } catch (InterruptedException e) {
                System.out.println("异常");
            }
        }

        try {
            // 全部释放再结束主进程
            semaphore.acquire(3);
            semaphore.release(3);
            System.out.println("剩余semaphore: " + semaphore.availablePermits());

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    class SimpleRunable implements Runnable {
        private String index;
        public SimpleRunable(String index){
            this.index = index;
        }

        public void run() {
            try {
                // 随机抛出异常
                businessRun(index);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally{
                semaphore.release();
                System.out.println(index + "释放锁执行成功");
            }
        }
    }

    private void businessRun(String index) throws InterruptedException{
        if(ThreadLocalRandom.current().nextInt(5) > 3){
            System.out.println(index + "跑出异常");
            throw new IllegalArgumentException();
        }
        Thread.sleep(1000 * 1);
        System.out.println(index + "获取锁执行成功, 可用资源：" + semaphore.availablePermits());
    }

}
