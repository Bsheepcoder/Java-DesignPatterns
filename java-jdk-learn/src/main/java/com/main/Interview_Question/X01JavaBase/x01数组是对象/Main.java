package com.main.Interview_Question.x01数组是对象;

public class Main {
    public static void main(String[] args) {
        Class clz = int[].class;
        System.out.println(clz.getSuperclass().getName());
    }
}
