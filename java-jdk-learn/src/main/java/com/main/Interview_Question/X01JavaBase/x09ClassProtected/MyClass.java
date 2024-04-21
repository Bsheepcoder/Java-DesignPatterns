package com.main.Interview_Question.X01JavaBase.x09ClassProtected;

/**
 * @author: qxd
 * @date: 2024/4/17
 * @description:
 */
public class MyClass {
    protected void protectedMethod() {
        System.out.println("Protected method called.");
    }
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.protectedMethod(); // 在同一包中，可以调用受保护方法
    }
}
