package com.design.pattern.mediator;

/**
 * @Author: 98050
 * @Time: 2019-01-17 17:48
 * @Feature:
 */
public class PartnerB extends AbstractCardPartner {

    public PartnerB(String name) {
        this.name = name;
    }

    @Override
    public void changeMoney(int money, AbstractMediator mediator) {
        mediator.win(this,money);
    }
}
