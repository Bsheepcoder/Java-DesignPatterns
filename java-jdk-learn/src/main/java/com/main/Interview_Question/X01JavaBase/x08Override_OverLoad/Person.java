package com.main.Interview_Question.X01JavaBase.x08Override_OverLoad;

public abstract class Person {

    String name;

    String age;

    Person(String name,String age){
        this.age = age;
        this.name = name;
    }

    public String eat(String food){
        return food;
    }

    private  String learn(String book){
        return book;
    }

    protected String sleep(int time){
        return "" + time + "h";
    }

    public abstract String sleep(int time, String time1);
}
