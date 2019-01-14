package com.design.pattern.command;

/**
 * @Author: 98050
 * @Time: 2019-01-14 13:27
 * @Feature: 实体命令类————Command
 */
public class BuyStock implements Order {

    private Stock abcStock;
    public BuyStock(Stock stock){
        this.abcStock = stock;
    }

    @Override
    public void execute() {
        abcStock.buy();
    }
}
