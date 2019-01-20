package com.design.pattern.templatemethod;

/**
 * @Author: 98050
 * @Time: 2019-01-20 18:13
 * @Feature:
 */
public class Test {
    public static void main(String[] args) {
        Game game1 = new Cricket();
        game1.play();
        System.out.println("----------------------------");
        Game game2 = new Football();
        game2.play();
    }
}
