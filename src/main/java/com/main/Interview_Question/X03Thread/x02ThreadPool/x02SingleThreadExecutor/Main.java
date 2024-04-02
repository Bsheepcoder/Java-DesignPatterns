package com.main.Interview_Question.X03Thread.x02ThreadPool.x02SingleThreadExecutor;

import java.util.concurrent.*;

/**
 *   单线程线程池
 *
 *   适用于串行执行任务的场景，一个任务一个任务地执行。在任务比较多的时候也是会导致OOM  OutOfMemoryError
 *
 */
public class Main {

    public static void main(String[] args) {

        /**
         *  1. Executors 创建
         */

        ExecutorService executor = Executors.newSingleThreadExecutor();

        // 模拟客户电话请求
        for (int i = 1; i <= 5; i++) {
            final int callId = i;
            executor.submit(() -> {
                System.out.println("接听电话 " + callId);
                System.out.println("处理客户问题...");
                System.out.println("电话 " + callId + " 处理完毕");
            });
        }

        // 关闭线程池
        executor.shutdown();

    }

    /**
     * 2. ThreadPoolExecutor 创建
     * @return
     */
    public static ExecutorService newSingleThreadExecutor() {
        return new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new
                LinkedBlockingQueue<Runnable>());
    }
}
