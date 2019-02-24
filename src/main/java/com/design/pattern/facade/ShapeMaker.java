package com.design.pattern.facade;

/**
 * @Author: 98050
 * @Time: 2019-02-24 17:57
 * @Feature:
 */
public class ShapeMaker {

    private Circle circle;

    private Square square;

    public ShapeMaker() {
        circle = new Circle();

        square = new Square();
    }

    public void drawCircle(){
        circle.draw();
    }

    public void drawSquare(){
        square.draw();
    }
}
