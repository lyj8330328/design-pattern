package com.design.pattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 98050
 * @Time: 2019-01-17 20:32
 * @Feature:
 */
public class CareTaker {
    private List<Memento> mementos = new ArrayList<Memento>();
    public void add(Memento state){
        mementos.add(state);
    }

    public Memento get(int index){
        return mementos.get(index);
    }
}
