package com.design.pattern.bridge;

/**
 * @Author: 98050
 * @Time: 2019-02-25 22:09
 * @Feature:
 */
public abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public abstract void draw();
}
