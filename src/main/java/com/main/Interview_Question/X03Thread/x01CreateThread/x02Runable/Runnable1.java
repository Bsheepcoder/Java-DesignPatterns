package com.main.Interview_Question.X03Thread.x01CreateThread.x02Runable;

class Runnable1 implements Runnable{
    /**
     *  runnable 创建线程
     *  1. run 无返回值
     *  2. run 方法只能抛出运行时异常，且无法捕获
     */
    @Override
    public void run() {
        System.out.println("当前线程："+Thread.currentThread().getName());
    }
}