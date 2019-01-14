package com.design.pattern.command;

/**
 * @Author: 98050
 * @Time: 2019-01-14 13:26
 * @Feature: 请求类，命令接收者————Receiver
 */
public class Stock {
    private String name = "ABC";
    private int quantity = 10;
    public void buy(){
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] bought");
    }
    public void sell(){
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] sold");
    }
}
