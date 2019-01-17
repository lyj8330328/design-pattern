package com.design.pattern.memento;

/**
 * @Author: 98050
 * @Time: 2019-01-17 20:30
 * @Feature:
 */
public class Memento {
    private String state;
    public Memento(String state){
        this.state = state;
    }
    public String getState(){
        return state;
    }
}
