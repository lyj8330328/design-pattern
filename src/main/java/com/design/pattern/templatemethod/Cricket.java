package com.design.pattern.templatemethod;

/**
 * @Author: 98050
 * @Time: 2019-01-20 18:11
 * @Feature:
 */
public class Cricket extends Game {

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialize Success !");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Start !");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game End !");
    }
}
