package com.main.Interview_Question.X02Collection.x07Iterator;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author: qxd
 * @date: 2024/4/19
 * @description:
 */
public class MyIterator implements Iterator {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    @Override
    public void forEachRemaining(Consumer action) {
        Iterator.super.forEachRemaining(action);
    }
}
