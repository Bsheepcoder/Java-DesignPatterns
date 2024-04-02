package com.main.Interview_Question.X03Thread.x02ThreadPool.x01FixedThreadPool;

import java.util.concurrent.*;

/**
 *   固定线程数的线程池
 *
 *   适用于处理CPU密集型的任务，确保CPU在长期被工作线程使用的情况下，尽可能的少的分
 * 配线程，即适用执行长期的任务。需要注意的是，FixedThreadPool 不会拒绝任务，在任务比较多的时
 * 候会导致 OOM。
 */
public class Main {
    public static void main(String[] args) {


        /**
         *   1. 使用 Executors 类的工厂方法创建
         */

        // 创建一个固定大小的线程池，大小为3
        ExecutorService executor1 = Executors.newFixedThreadPool(3);

        /**
         *  2. 直接使用 ThreadPoolExecutor 类进行创建，可以更灵活地设置线程池的各种参数。
         *
         *      使用无界队列 LinkedBlockingQueue（队列容量为 Integer.MAX_VALUE），运行中的线程池不会拒绝任务，即不会调用RejectedExecutionHandler.rejectedExecution()方法。
         *
         */
        // 创建一个大小为3的固定线程池
        ExecutorService executor2 = new ThreadPoolExecutor(
                3, 3, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>()
        );

        /**
         *  执行
         */

        // 提交任务给线程池
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;

            /**
             *   通过submit提交线程任务
             */
            executor1.submit(() -> {
                try {
                    System.out.println("开始执行任务 " + taskId);
                    Thread.sleep(2000); // 模拟任务执行时间
                    System.out.println("任务 " + taskId + " 执行完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // 关闭线程池
        executor1.shutdown();
    }

}
