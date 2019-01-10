package com.design.pattern.simplefactory;

/**
 * @Author: 98050
 * @Time: 2019-01-10 12:00
 * @Feature: 简单工厂
 */
public class SimpleFactory {

    public Product createProduct(int type){
        if (type == 1){
            return new ConcreteProduct();
        }else if (type == 2){
            return new ConcreteProduct2();
        }else {
            return new ConcreteProduct3();
        }
    }
}
