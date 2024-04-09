package com.main.Interview_Question.X02Collection.x01遍历ArrayList移除一个元素;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeletListItem {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        Iterator iterator = list.iterator();

        while(iterator.hasNext()) {
            if(iterator.next().equals("jay")){
                iterator.remove();
            }
        }
    }
}
