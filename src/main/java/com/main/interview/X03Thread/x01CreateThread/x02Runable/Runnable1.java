package com.main.interview.X03Thread.x01CreateThread.x02Runable;

class Runnable1 implements Runnable{
    @Override
    public void run() {
        System.out.println("当前线程："+Thread.currentThread().getName());
    }
}