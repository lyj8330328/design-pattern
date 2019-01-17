package com.design.pattern.memento;

/**
 * @Author: 98050
 * @Time: 2019-01-17 20:31
 * @Feature:
 */
public class Originator {
    private String state;
    public void setState(String state){
        this.state = state;
    }
    public String getState(){
        return state;
    }
    public Memento saveStateToMemento(){
        return new Memento(state);
    }
    public void getStateFromMemento(Memento Memento){
        state = Memento.getState();
    }
}
