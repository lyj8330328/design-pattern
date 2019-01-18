package com.design.pattern.observer;

/**
 * @Author: 98050
 * @Time: 2019-01-18 21:23
 * @Feature:
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
