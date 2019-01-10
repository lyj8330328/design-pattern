package com.design.pattern.abstractfactory;

/**
 * @Author: 98050
 * @Time: 2019-01-10 14:50
 * @Feature: 原材料工厂，需要材料A,B
 */
public abstract class AbstractIngredientFactory {
    /**
     * 创建材料A
     * @return
     */
    abstract IngredientA createIngredientA();

    /**
     * 创建材料B
     * @return
     */
    abstract IngredientB createIngredientB();
}
