package com.design.pattern.observer;

/**
 * @Author: 98050
 * @Time: 2019-01-18 21:28
 * @Feature:
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println( "Binary String: "
                + Integer.toBinaryString( subject.getState() ) );
    }
}
