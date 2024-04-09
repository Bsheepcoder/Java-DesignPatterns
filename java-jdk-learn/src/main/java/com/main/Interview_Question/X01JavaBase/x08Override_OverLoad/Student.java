package com.main.Interview_Question.X01JavaBase.x08Override_OverLoad;

public class Student extends Person{

    Student(String name, String age) {
        super(name, age);
    }

    /**
     * 方法重写，方法签名必须一致
     * @param food
     * @return
     */
    @Override
    public String eat(String food) {
        return "no eat";
    }

    /**
     * 方法重写，方法签名必须一致
     * @param time
     * @return
     */
    @Override
    public String sleep(int time) {
        return "no time";
    }

    /**
     * 父类的抽象方法实现，方法签名必须一致
     * @param time
     * @param time1
     * @return
     */

    public String sleep(int time,String time1){
        return "1";
    }

    /**
     * 方法重载,方法签名均可不一致
     * @param time1
     * @param name
     * @return
     */
    private int eat(int time1,String name){
        return 1;
    }



    public static void main(String[] args) {

    }


}
