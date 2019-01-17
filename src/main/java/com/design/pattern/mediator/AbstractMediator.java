package com.design.pattern.mediator;

/**
 * @Author: 98050
 * @Time: 2019-01-17 17:59
 * @Feature:
 */
public abstract class AbstractMediator {

    /**
     * 赢钱
     * @param winner
     * @param money
     */
    public abstract void win(AbstractCardPartner winner,int money);

}
