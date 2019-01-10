package com.design.pattern.simplefactory;

/**
 * @Author: 98050
 * @Time: 2019-01-10 11:56
 * @Feature:
 */
public class Client {

    public static void main(String[] args) {
        Product product;
        SimpleFactory simpleFactory = new SimpleFactory();
        product = simpleFactory.createProduct(1);
    }
}
