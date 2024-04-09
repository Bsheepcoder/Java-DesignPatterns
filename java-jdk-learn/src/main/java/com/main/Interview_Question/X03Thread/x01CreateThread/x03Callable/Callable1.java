package com.main.Interview_Question.X03Thread.x01CreateThread.x03Callable;

import java.util.concurrent.Callable;

class Callable1 implements Callable<Integer> {

    /**
     *
     * callable 执行 call 方法
     *
     * 1. call方法有返回值，运行抛出异常
     * 2. callable 是泛型接口，可以自定义返回类型，通过Future和FutureTask可以捕获异步执行结果
     *
     */
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}