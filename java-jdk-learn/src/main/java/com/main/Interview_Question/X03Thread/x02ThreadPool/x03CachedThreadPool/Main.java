package com.main.Interview_Question.X03Thread.x02ThreadPool.x03CachedThreadPool;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();


        // 模拟快递派送请求
        for (int i = 1; i <= 10; i++) {
            final int deliveryId = i;
            executor.submit(() -> {
                System.out.println("派送包裹 " + deliveryId);
                System.out.println("快递员正在派送...");
                System.out.println("包裹 " + deliveryId + " 派送完毕");
            });
        }

        // 关闭线程池
        executor.shutdown();
    }

    /**
     * 核心线程是期望达到的并发量，非核心线程是在适当情况下可以的超载量
     * @return
     */
    public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
    }
}
