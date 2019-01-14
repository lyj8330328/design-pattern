package com.design.pattern.prototype;

import javax.print.DocFlavor;

/**
 * @Author: 98050
 * @Time: 2019-01-11 16:54
 * @Feature:
 */
public class Test {

    public static void main(String[] args) {
        Prototype prototype = new ConcretePrototype("123");
        Prototype prototype1 = prototype.myclone();
        System.out.println(prototype1);
    }
}
