package com.main.interview.X03Thread.x01CreateThread.x03Cabllable;

import java.util.concurrent.Callable;

class Callable1 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}