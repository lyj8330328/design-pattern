package com.design.pattern.factorymethod;

/**
 * @Author: 98050
 * @Time: 2019-01-10 12:52
 * @Feature:
 */
public class ConcreteFactory extends Factory {

    @Override
    public Product factoryMethod() {
        return new ConcreteProduct();
    }

    @Override
    public void doSomething() {
        factoryMethod().show();
    }
}
