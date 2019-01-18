package com.design.pattern.observer;

/**
 * @Author: 98050
 * @Time: 2019-01-18 21:28
 * @Feature:
 */
public class HexObserver extends Observer {

    public HexObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println( "Hex String: "
                + Integer.toHexString( subject.getState() ).toUpperCase() );
    }
}
