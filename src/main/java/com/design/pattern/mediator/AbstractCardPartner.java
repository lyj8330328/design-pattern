package com.design.pattern.mediator;

/**
 * @Author: 98050
 * @Time: 2019-01-17 17:43
 * @Feature: 抽象牌友类
 */
public abstract class AbstractCardPartner {
    public String name;
    public int ownMoney;

    /**
     * 改变money
     * @param money
     * @param mediator
     */
    public abstract void changeMoney(int money, AbstractMediator mediator);
}
