package com.design.pattern.strategy;

/**
 * @Author: 98050
 * @Time: 2019-01-19 23:02
 * @Feature:
 */
public class Test {
    public static void main(String[] args) {
        Context context = new Context(new AddStrategy());
        System.out.println("1 + 2 =" + context.executeStrategy(1, 2));

        Context context2 = new Context(new SubStrategy());
        System.out.println("1 - 2 =" + context2.executeStrategy(1, 2));
    }
}
