package com.design.pattern.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 98050
 * @Time: 2019-01-17 18:03
 * @Feature:
 */
public class ConcreteMediator extends AbstractMediator {

    private List<AbstractCardPartner> partners;

    public ConcreteMediator(List<AbstractCardPartner> partners) {
        this.partners = partners;
    }

    @Override
    public void win(AbstractCardPartner winner, int money) {
        for (AbstractCardPartner temp : this.partners){
            if (temp.name.equals(winner.name)){
                temp.ownMoney += money;
            }else {
                temp.ownMoney -= money;
            }
        }
    }

}
