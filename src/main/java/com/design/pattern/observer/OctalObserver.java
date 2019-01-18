package com.design.pattern.observer;

/**
 * @Author: 98050
 * @Time: 2019-01-18 21:28
 * @Feature:
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println( "Octal String: "
                + Integer.toOctalString( subject.getState() ) );
    }
}
