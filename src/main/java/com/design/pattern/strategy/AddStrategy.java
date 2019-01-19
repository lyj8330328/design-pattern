package com.design.pattern.strategy;

/**
 * @Author: 98050
 * @Time: 2019-01-19 23:00
 * @Feature:
 */
public class AddStrategy implements Strategy {
    @Override
    public int doOperation(int a, int b) {
        return a+b;
    }
}
