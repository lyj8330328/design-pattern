package com.design.pattern.state;

/**
 * @Author: 98050
 * @Time: 2019-01-18 22:10
 * @Feature:
 */
public class Context {
    private State state;

    public Context(){
        state = null;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
