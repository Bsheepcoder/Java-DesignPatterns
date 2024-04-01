package com.main.interview.X01JavaBase.x07TryCatch;

public class Main {

    public static void main(String[] args) {
        System.out.println(Main.test());
    }


    /**
     *  总结：
     *      有finally 只返回 finally 的return
     *      没有 finally 捕获异常只返回 catch
     *      没有异常、且没有 finally 才能返回 try 语句的 return
     *
     *
     *  如果finally中没有return语句，但是改变了要返回的值，分为以下两种情况：
     *
     *      1）如果return的数据是基本数据类型或文本字符串，则在finally中对该基本数据的改变不起作用，try中的return语句依然会返回进入finally块之前保留的值。
     *
     *      2）如果return的数据是引用数据类型，而在finally中对该引用数据类型的属性值的改变起作用，try中的return语句返回的就是在finally中改变后的该属性的值。
     */

    public static String test(){

        try{
            String s = "ok";
            //throw new RuntimeException();
            return s;
        }catch (Exception e){
            e.printStackTrace();
            return "我是catch输出";
        }finally {
            return "我是finally输出";
        }

    }
}
