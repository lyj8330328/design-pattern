package com.design.pattern.builder.stringbuilder;

/**
 * @Author: 98050
 * @Time: 2019-01-11 16:04
 * @Feature:
 */
public class MyStringBuilder extends MyAbstractStringBuilder {

    public MyStringBuilder(){
        super(16);
    }

    @Override
    public String toString() {
        return new String(value, 0, count);
    }
}
