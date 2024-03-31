package com.main.算法分析.X01位运算.x01与或非;

public class Main {

    public static void main(String[] args) {
        Integer a = - 1;
        Integer b = 11;
        Integer c = 0;
        print("之前：");
        print("a: " +Integer.toBinaryString(a) + " | " + a);
        print("b: " +Integer.toBinaryString(b)+ " | " + b);
        print("c: " +Integer.toBinaryString(c)+ " | " + c);

        // 没有 <<<
        // 只有 >>> 用于负数的 无符号右移,
        // ^ 异或： 不同位 1 相同为 0
        // c = a ^ b;
        // & 与 ： 只有相同为 1 则为 1  ，其他都为 0
        // c = a & b;！！11
        // | 或 ： 有一个为 1 则为 1 ,  都为 0 就是 0
        // c = a | b;
        // ~ 取反： 正数a取反 = -a - 1. - a取反 = a - 1
        a = a >>> 1;
        print("之后：");
        print("a: " + Integer.toBinaryString(a) + " | " + a);
        print("b: " +Integer.toBinaryString(b)+ " | " + b);
        print("c: " +Integer.toBinaryString(c)+ " | " + c);
    }

    public static void print(Object s){
        System.out.println(s);
    }
}
