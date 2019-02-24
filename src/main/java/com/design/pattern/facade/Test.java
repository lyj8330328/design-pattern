package com.design.pattern.facade;

/**
 * @Author: 98050
 * @Time: 2019-02-24 18:00
 * @Feature:
 */
public class Test {

    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawSquare();
    }
}
