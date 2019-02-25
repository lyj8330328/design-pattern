package com.design.pattern.bridge;

/**
 * @Author: 98050
 * @Time: 2019-02-25 22:10
 * @Feature:
 */
public class Blue implements Color {
    @Override
    public void paint(String shape) {
        System.out.println("蓝色的" + shape);
    }
}
