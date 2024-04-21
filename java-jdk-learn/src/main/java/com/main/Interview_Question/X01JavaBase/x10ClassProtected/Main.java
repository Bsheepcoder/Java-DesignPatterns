package com.main.Interview_Question.X01JavaBase.x10ClassProtected;

import com.main.Interview_Question.X01JavaBase.x09ClassProtected.MyClass;

/**
 * @author: qxd
 * @date: 2024/4/17
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        //obj.protectedMethod(); // 在不同一包中，不可以调用受保护方法
    }
}
