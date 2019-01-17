package com.design.pattern.mediator;

import java.io.Console;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: 98050
 * @Time: 2019-01-17 17:48
 * @Feature:
 */
public class Test {

    public static void main(String[] args) {
        AbstractCardPartner A = new PartnerA("玩家A");
        A.ownMoney = 20;
        AbstractCardPartner B = new PartnerB("玩家B");
        B.ownMoney = 20;

        List<AbstractCardPartner> partners = Arrays.asList(A,B);

        //中介者
        AbstractMediator mediator = new ConcreteMediator(partners);

        System.out.println("----------------A赢了----------------------");
        //A赢了钱
        A.changeMoney(5,mediator);
        for (AbstractCardPartner partner : partners){
            System.out.println(partner.name + "的钱：" + partner.ownMoney);
        }
        System.out.println("----------------B赢了----------------------");
        //B赢了钱
        B.changeMoney(10,mediator);
        for (AbstractCardPartner partner : partners){
            System.out.println(partner.name + "的钱：" + partner.ownMoney);
        }
    }
}
