package com.design.pattern.prototype;

/**
 * @Author: 98050
 * @Time: 2019-01-11 16:53
 * @Feature:
 */
public class ConcretePrototype extends Prototype{

    private String filed;

    public ConcretePrototype(String filed) {
        this.filed = filed;
    }

    @Override
    Prototype myclone() {
        return new ConcretePrototype(filed);
    }

    @Override
    public String toString() {
        return "ConcretePrototype{" +
                "filed='" + filed + '\'' +
                '}';
    }
}
