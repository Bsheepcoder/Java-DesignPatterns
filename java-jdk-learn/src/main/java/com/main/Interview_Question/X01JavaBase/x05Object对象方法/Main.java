package com.main.Interview_Question.X01JavaBase.x05Object对象方法;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        o.equals(o);
        o.toString();
        o.hashCode();
        o.getClass();
        o.notify();
        o.notifyAll();
        o.wait();
        // protected void finalize()
        /**
         * finalize 是Object类的一个方法，该方法一般由垃圾回收器来调用，
         * 当我们调用 System.gc() 方法 的时候，由垃圾回收器调用 finalize() 方法，回收垃圾，JVM并不保证此方法总被调用。
         */
    }
}
