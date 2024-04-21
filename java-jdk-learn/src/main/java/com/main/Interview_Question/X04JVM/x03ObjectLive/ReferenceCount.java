package com.main.Interview_Question.X04JVM.x03ObjectLive;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author: qxd
 * @date: 2024/4/13
 * @description:
 */
public class ReferenceCount {

    Object instance = null;
    public static void main(String[] args) {
        ReferenceCount obj1 = new ReferenceCount();
        ReferenceCount obj2 = new ReferenceCount();
        obj1.instance = obj2;
        obj2.instance = obj1;
        obj1 = null;
        obj2 = null;


        Object obj = new Object();
        WeakReference<Object> weakRef = new WeakReference<>(obj);

        // 将对象置为null，使其只有弱引用指向
        obj = null;

        // 执行垃圾回收
        System.gc();

        // 弱引用对象可能已经被回收，因此需要检查是否为null
        if (weakRef.get() != null) {
            System.out.println("Weak Reference still holds the object");
        } else {
            System.out.println("Weak Reference does not hold the object anymore");
        }

        Object obj4 = new Object();
        SoftReference<Object> softRef = new SoftReference<>(obj);

        // 将对象置为null，使其只有软引用指向
        obj4 = null;

        // 执行一些其他操作，可能会消耗内存

        // 获取软引用指向的对象
        Object retrievedObj = softRef.get();

        // 打印软引用指向的对象
        System.out.println("Retrieved object: " + retrievedObj);

    }
}
