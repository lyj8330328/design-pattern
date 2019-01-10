package com.design.pattern.abstractfactory;

/**
 * @Author: 98050
 * @Time: 2019-01-10 15:35
 * @Feature: 获取工厂
 */
public class FactoryProducer {

    public static AbstractIngredientFactory getFactory(int type){
        if (type == 1){
            return new AbstractIngredientFactory1Impl();
        }else {
            return new AbstractIngredientFactory2Impl();
        }
    }
}
