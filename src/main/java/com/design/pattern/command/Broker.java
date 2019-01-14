package com.design.pattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 98050
 * @Time: 2019-01-14 13:30
 * @Feature: 命令调用类，接收命令并执行————Invoker
 */
public class Broker {
    private List<Order> orders = new ArrayList<Order>();

    public void takeOrder(Order order){
        orders.add(order);
    }

    public void placeOrders(){
        for (Order order : orders){
            order.execute();
        }
        orders.clear();
    }
}
