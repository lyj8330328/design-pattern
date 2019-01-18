package com.design.pattern.observer;

/**
 * @Author: 98050
 * @Time: 2019-01-18 21:30
 * @Feature:
 */
public class Test {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new HexObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);
        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }

}
