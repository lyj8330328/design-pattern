package com.design.pattern.factorymethod;

/**
 * @Author: 98050
 * @Time: 2019-01-10 13:08
 * @Feature: 客户
 */
public class Client {
    public static void main(String[] args) {

        ConcreteFactory concreteFactory = new ConcreteFactory();
        concreteFactory.doSomething();
    }
}
