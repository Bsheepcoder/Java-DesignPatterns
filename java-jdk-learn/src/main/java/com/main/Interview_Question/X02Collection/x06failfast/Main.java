package com.main.Interview_Question.X02Collection.x06failfast;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author: qxd
 * @date: 2024/4/14
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        // 创建一个 CopyOnWriteArrayList 对象
        List<Integer> list = new CopyOnWriteArrayList<>();

        // 创建一个线程向列表中添加数据
        Thread writerThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });

        // 创建一个线程遍历列表
        Thread readerThread = new Thread(() -> {
            for (Integer num : list) {
                System.out.println("Read value: " + num);
            }
        });

        // 启动两个线程
        writerThread.start();
        readerThread.start();

        // 等待两个线程执行完毕
        try {
            writerThread.join();
            readerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 输出列表的大小
        System.out.println("List size: " + list.size());
    }
}
