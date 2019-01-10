package com.design.pattern.abstractfactory;

/**
 * @Author: 98050
 * @Time: 2019-01-10 14:57
 * @Feature: 具体工厂1
 */
public class AbstractIngredientFactory1Impl extends AbstractIngredientFactory {

    @Override
    public IngredientA createIngredientA() {
        return new IngredientA1Impl();
    }

    @Override
    public IngredientB createIngredientB() {
        return new IngredientB1Impl();
    }
}
