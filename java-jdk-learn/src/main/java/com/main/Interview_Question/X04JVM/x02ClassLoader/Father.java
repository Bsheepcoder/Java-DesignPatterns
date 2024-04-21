package com.main.Interview_Question.X04JVM.x02ClassLoader;

/**
 * @author: qxd
 * @date: 2024/4/13
 * @description:
 */
public class Father {

    static {
        System.out.println("父类-静态代码块");
    }

    {
        System.out.println("父类-普通代码块");
    }

    public Father() {
        System.out.println("父类-构造函数");
    }
}
