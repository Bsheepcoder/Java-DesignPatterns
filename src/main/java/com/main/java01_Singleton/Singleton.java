package com.main.java01_Singleton;


/**
 * 简单单例模式-饿汉式
 */
public class Singleton {

    /**
     * final 不能改变这个对象的引用
     */
    private final static Singleton instance = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(){
        return instance;
    }

    // 通过getInstance获取唯一对象
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }
}
