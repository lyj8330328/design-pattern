package com.design.pattern.bridge;

/**
 * @Author: 98050
 * @Time: 2019-02-25 22:14
 * @Feature:
 */
public class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        color.paint("正方形");
    }
}
