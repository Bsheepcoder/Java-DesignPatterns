package com.main.interview.X02Collection.x02Collection;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        /**
         *  1. Collection 继承了 Iterable类
         *      public interface Collection<E> extends Iterable<E>
         *  2. Iterable 迭代类
         *      Iterable 接口只包含一个方法 iterator()，该方法返回一个迭代器对象，因此任何类只要实现了该方法，都可以被称为是可迭代的。
         *  3. Object 类是java中所有类的父类
         *  4. Objects 类是Java7 引入的工具类，其中的静态方法用于判断类的属性
         *  5. Collection 做了哪些工作？
         *          提供了一种统一的方式来操作集合，而不管具体的集合类型，在类中定义了继承方法的各种规范
         *
         *          定义接口 Set, List, Map, SortedSet, SortedMap, HashSet, TreeSet, ArrayList, LinkedList, Vector, Collections, Arrays, AbstractCollection
         *
         *          存储对象：Collection 接口可以存储对象，其中的对象可以是任意类型。这些对象存储在集合中，并且可以根据需要添加、删除或修改。
         *
         *          遍历集合：Collection 接口提供了多种遍历集合的方法，包括迭代器模式、增强型 for 循环等。
         *
         *          获取集合大小：可以使用 size() 方法获取集合中元素的数量。
         *
         *          检查集合是否为空：可以使用 isEmpty() 方法检查集合是否为空。
         *
         *          添加、删除元素：Collection 接口提供了 add(E e)、remove(Object o) 等方法用于向集合中添加和删除元素。
         *
         *          检查集合中是否包含某个元素：可以使用 contains(Object o) 方法检查集合中是否包含指定的元素。
         *
         *          清空集合：可以使用 clear() 方法清空集合中的所有元素。
         *
         *          将集合转换为数组：Collection 接口提供了 toArray() 方法，用于将集合转换为数组。
         *
         *          获取集合的迭代器：Collection 接口提供了 iterator() 方法，用于获取集合的迭代器，从而可以遍历集合中的元素。
         */

        // Objects os = new Objects();  objgects 构造方法为私有
        Object o = new Object();
        Collection c = new ArrayList();
        Main.print(c.hashCode());

    }

    public static void print(Object s){
        System.out.println(s.toString());
    }
}
