package com.main.面试八股.x01数组是对象;

public class Main {
    public static void main(String[] args) {
        Class clz = int[].class;
        System.out.println(clz.getSuperclass().getName());
    }
}
