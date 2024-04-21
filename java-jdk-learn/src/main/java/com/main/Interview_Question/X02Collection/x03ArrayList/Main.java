package com.main.Interview_Question.X02Collection.x03ArrayList;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        /**
         *  1. Arrays 的作用？
         *          Arrays 是 int [] 对象的工具类，其中实现了 操作 int[] 的静态工具方法
         *
         *          排序数组：Arrays.sort() 方法用于对数组进行排序。它提供了对各种基本数据类型和对象数组进行排序的重载版本。
         *
         *          搜索数组：Arrays.binarySearch() 方法用于在已排序的数组中进行二分搜索。
         *
         *          填充数组：Arrays.fill() 方法用指定的值填充数组的所有元素。
         *
         *          复制数组：Arrays.copyOf() 方法用于复制数组的一部分或全部内容到一个新的数组中。
         *
         *          比较数组：Arrays.equals() 方法用于比较两个数组是否相等。
         *
         *          将数组转换为字符串：Arrays.toString() 方法用于将数组转换为字符串表示形式，便于输出和调试。
         *
         *          数组转换为集合：Arrays.asList() 方法将数组转换为 List 集合。
         *
         *          数组填充：Arrays.parallelSetAll() 方法和 Arrays.setAll() 方法用于以并行或顺序方式根据给定的生成器函数填充数组。
         *
         *
         */
        String s = "1,2,3,4,5,6";
        List<String> sl = Arrays.asList(s.split(","));
        System.out.println(sl);

        int [] nums = new int[]{1,2,3,4,5,6};

        // Arrays.binarySearch() : 必须先排序
        Arrays.sort(nums);
        int get = Arrays.binarySearch(nums,5);
        System.out.println(get);


        // int [] 转 List
        // StreamSupport  返回了 一个 Stream 对象
        List<Integer> a = Arrays.stream(nums).boxed().collect(Collectors.toList());
        System.out.println(a.toString());


        /**
         *    ArrayList动态数组
         *    1。ArrayList 有什么功能？
         *          ArrayList 实现了 Serializable, 并指定了 serialVersionUID ,
         *          定义了默认容积为 10
         *    2. ArrayList 中 使用了 transient关键字
         *          transient 是 Java 中的关键字，用于声明一个字段（成员变量），表示该字段不会被序列化。
         *    3. ArrayList 构造函数
         *
         *       public ArrayList(int initialCapacity) {
         *         if (initialCapacity > 0) {
         *             this.elementData = new Object[initialCapacity];
         *         } else if (initialCapacity == 0) {
         *             this.elementData = EMPTY_ELEMENTDATA;
         *         } else {
         *             throw new IllegalArgumentException("Illegal Capacity: "+
         *                                                initialCapacity);
         *         }
         *     }
         *
         *    4. ArrayList 的扩容规则
         *
         *         见 grow 函数 ，也就是 扩大 旧的 ArrayList.size 的 一半 ，最大为 2^31 - 8 , 8bit 是用来存储这个size本身
         *         int oldCapacity = elementData.length;
         *         int newCapacity = oldCapacity + (oldCapacity >> 1);
         */

        /**
         *  元素 和 elementdata 的关系，  ArrayList 中的元素 就是存储在 elementdata 中
         */
        // 创建一个 ArrayList 对象
        // 创建一个 ArrayList 对象
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        // 使用反射获取 elementData 字段
        Field elementDataField = ArrayList.class.getDeclaredField("elementData");
        elementDataField.setAccessible(true); // 设置字段可访问

        // 获取 elementData 数组
        Object[] elementData = (Object[]) elementDataField.get(list);

        // 输出 elementData 数组中的元素
        System.out.println("elementData 数组中的元素：");
        for (Object obj : elementData) {
            if (obj != null) {
                System.out.println(obj);
            }
        }

        // 输出 ArrayList 中的元素
        System.out.println("ArrayList 中的元素：");
        for (Integer num : list) {
            System.out.println(num);
        }

        /**
         *  为什么 ArrayList 中 存储数据的 elementdata 被标记了 transient， 依然可以正常反序列化？
         *
         *      ArrayList在序列化的时候会调用writeObject，直接将size和element写入ObjectOutputStream；
         *      反序列化时调用readObject，从ObjectInputStream获取size和element，再恢复到elementData。
         *
         *    ArrayList 实现的方法
         *     private void writeObject(java.io.ObjectOutputStream s)
         *         throws java.io.IOException{
         *         // Write out element count, and any hidden stuff
         *         int expectedModCount = modCount;
         *         s.defaultWriteObject();
         *
         *         // Write out size as capacity for behavioural compatibility with clone()
         *         s.writeInt(size);
         *
         *         // Write out all elements in the proper order.
         *         for (int i=0; i<size; i++) {
         *             s.writeObject(elementData[i]);  // 只将 元素 write 写入
         *         }
         *
         *         if (modCount != expectedModCount) {
         *             throw new ConcurrentModificationException();
         *         }
         *     }
         *
         *     private void readObject(java.io.ObjectInputStream s)
         *         throws java.io.IOException, ClassNotFoundException {
         *         elementData = EMPTY_ELEMENTDATA;
         *
         *         // Read in size, and any hidden stuff
         *         s.defaultReadObject();
         *
         *         // Read in capacity
         *         s.readInt(); // ignored
         *
         *         if (size > 0) {
         *             // be like clone(), allocate array based upon size not capacity
         *             ensureCapacityInternal(size);
         *
         *             Object[] a = elementData;   // 创建了一个新的对象
         *             // Read in all elements in the proper order.
         *             for (int i=0; i<size; i++) {
         *                 a[i] = s.readObject();
         *             }
         *         }
         *     }
         *
         *
         *  为什么不直接用elementData来序列化，而采用上诉的方式来实现序列化呢？
         *      原因在于elementData是一个缓存数组，它通常会预留一些容量，等容量不足时再扩充容量，
         *      那么有些空间可能就没有实际存储元素，采用上诉的方式来实现序列化时，
         *      就可以保证只序列化实际存储的那些元素，而不是整个数组，从而节省空间和时间。
         *
         */
        // 序列化
        try {
            /* 序列化 ArrayList 对象 */
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("list.ser"));
            out.writeObject(list);
            out.close();

            // 反序列化 ArrayList 对象
            ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get("list.ser")));
            ArrayList<Integer> newList = (ArrayList<Integer>) in.readObject();
            in.close();

            // 输出反序列化后的 ArrayList 对象
            System.out.println("反序列化后的 ArrayList 对象：" + newList);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
