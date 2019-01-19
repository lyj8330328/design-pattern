package com.design.pattern.strategy;

/**
 * @Author: 98050
 * @Time: 2019-01-19 23:00
 * @Feature:
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int a,int b){
        return strategy.doOperation(a, b);
    }
}
