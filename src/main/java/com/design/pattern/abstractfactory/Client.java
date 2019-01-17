package com.design.pattern.abstractfactory;

import javax.swing.text.Keymap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: 98050
 * @Time: 2019-01-10 14:59
 * @Feature: 获取材料
 */
public class Client {

    public static void main(String[] args) {
        AbstractIngredientFactory abstractIngredientFactory = FactoryProducer.getFactory(1);
        abstractIngredientFactory.createIngredientA().show();
        abstractIngredientFactory.createIngredientB().show();

        AbstractIngredientFactory abstractIngredientFactory2 = FactoryProducer.getFactory(2);
        abstractIngredientFactory2.createIngredientA().show();
        abstractIngredientFactory2.createIngredientB().show();

        List<String> list = new ArrayList<String>();
    }
}
