package com.main.Interview_Question.X02Collection.x05HashMap;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @author: qxd
 * @date: 2024/4/14
 * @description:
 */

// 假设有一个枚举类型表示一周中的每一天
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Map<String,Integer> linkmap = new LinkedHashMap<>();
        Map<String,Integer> treemap = new TreeMap<>();
        Map<Day,Integer> enummap = new EnumMap<>(Day.class);
        Map<String,Integer> concurrentHashmap = new ConcurrentHashMap<>();
        System.out.println(1 << 30);
        System.out.println(Integer.toBinaryString(1 << 30));
        System.out.println(tableSizeFor(100));



        final Map<Integer, String> map = new ConcurrentHashMap<>();

        final CountDownLatch latch = new CountDownLatch(2);

        // 线程1向map中放入数据
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                map.put(i, Integer.toString(i));
            }
            latch.countDown();
        }).start();

        // 线程2向map中放入数据
        new Thread(() -> {
            for (int i = 10000; i < 20000; i++) {
                map.put(i, Integer.toString(i));
            }
            latch.countDown();
        }).start();

        // 等待两个线程执行完毕
        latch.await();

        // 输出map的大小
        System.out.println("Map size: " + map.size());
     }

    public static  int tableSizeFor(int cap) {
        int n = -1 >>> Integer.numberOfLeadingZeros(cap - 1);
        return (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1;
    }
}
