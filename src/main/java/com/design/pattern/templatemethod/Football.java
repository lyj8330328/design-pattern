package com.design.pattern.templatemethod;

/**
 * @Author: 98050
 * @Time: 2019-01-20 18:11
 * @Feature:
 */
public class Football extends Game {

    @Override
    void initialize() {
        System.out.println("Football Game Initialize Success !");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Start !");
    }

    @Override
    void endPlay() {
        System.out.println("Football Game End !");
    }
}
