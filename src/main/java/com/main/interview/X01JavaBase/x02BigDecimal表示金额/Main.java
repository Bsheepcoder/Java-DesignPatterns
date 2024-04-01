package com.main.interview.x02BigDecimal表示金额;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        // 1.精度
        BigDecimal bigDecimal = new BigDecimal(1234567890987654321.98765432112345);
        // 存储：123.12312321
        // 输出：123.1231232100000028140129870735108852386474609375

        // 存储：123.123123211111111
        // 输出：123.123123211111106911630486138164997100830078125
        System.out.println(bigDecimal);

        // 2. 比较
        BigDecimal a = new BigDecimal("1");
        BigDecimal b = new BigDecimal("1.0");
        System.out.println(a.equals(b)); //false   还会比较精度
        System.out.println(a.compareTo(b)); // 0  如果相等就返回 0，如果第 1 个数比第 2 个数大则返回 1，反之返回-1。

    }
}
