package com.main.Interview_Question.X04JVM.x02ClassLoader;

/**
 * @author: qxd
 * @date: 2024/4/13
 * @description:
 */
public class Son extends Father{

    static {
        System.out.println("子类-静态代码块");
    }

    {
        System.out.println("子类-普通代码块");
    }

    public Son() {
        System.out.println("子类-构造函数");
    }

}
