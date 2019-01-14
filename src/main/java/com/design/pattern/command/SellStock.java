package com.design.pattern.command;

/**
 * @Author: 98050
 * @Time: 2019-01-14 13:29
 * @Feature: 实体命令类————Command
 */
public class SellStock implements Order {

    private Stock abcStock;
    public SellStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.sell();
    }
}
