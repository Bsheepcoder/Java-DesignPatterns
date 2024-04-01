package com.main.interview.X03Thread.x01CreateThread.x02Runable;

public class RunableTest {
    public static void main(String[] args){
        Thread thread = new Thread(new Runnable1());
        thread.start();
        System.out.println("主线程：["+Thread.currentThread().getName()+"]");
    }
}