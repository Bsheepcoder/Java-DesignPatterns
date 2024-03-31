package com.main.interview.x03基本数据类型的拆箱和装箱;

public class Main {
    public static void main(String[] args) {

        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b);

        Integer c = 200;
        Integer d = 200;
        System.out.println(c == d);
        System.out.println(c.equals(d));
        System.out.println("c: " + c + " d: " + d);
        // 默认Integer cache 的下限是-128，上限默认127
        // 当数据超出范围时，拆箱就会创建一个新的对象,地址不相同
    }
}
