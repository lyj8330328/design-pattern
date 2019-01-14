package com.design.pattern.chainofresponsibility;

/**
 * @Author: 98050
 * @Time: 2019-01-11 19:24
 * @Feature:
 */
public class DEBUGLogger extends AbstractLogger {

    public DEBUGLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("DEBUG log:" + message);
    }
}
