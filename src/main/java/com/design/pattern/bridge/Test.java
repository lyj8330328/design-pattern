package com.design.pattern.bridge;

/**
 * @Author: 98050
 * @Time: 2019-02-25 22:15
 * @Feature:
 */
public class Test {

    public static void main(String[] args) {
        Color white = new White();
        Shape circle = new Circle(white);
        circle.draw();

        Color blue = new Blue();
        Shape square = new Square(blue);
        square.draw();
    }
}
