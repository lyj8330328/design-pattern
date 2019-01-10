package com.design.pattern.factorymethod;

/**
 * @Author: 98050
 * @Time: 2019-01-10 12:48
 * @Feature:
 */
public abstract class Factory {
    /**
     * 创建产品对象
     * @return
     */
    abstract public Product factoryMethod();

    public void doSomething(){
    }
}
