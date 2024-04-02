package com.main.Interview_Question.X03Thread.x01CreateThread.x03Callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) {
        Callable1 c = new Callable1();


        /**
         *  1. 将callable对象 构建 FutureTask
         *  2. 将FutureTask 放入 Thread对象 执行 start()
         *  3. 通过 FutureTask 的 get() 方法 拿到执行结果
         */
        //异步计算的结果
        FutureTask<Integer> result = new FutureTask<>(c);

        new Thread(result).start();

        try {
            //等待任务完成，返回结果
            int sum = result.get();
            System.out.println(sum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}