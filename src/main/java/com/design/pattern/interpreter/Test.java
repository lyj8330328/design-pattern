package com.design.pattern.interpreter;

/**
 * @Author: 98050
 * @Time: 2019-01-14 17:07
 * @Feature:
 */
public class Test {

    public static void main(String[] args) {
        Context context = new Context();
        context.freeRide("西安的老人");
        context.freeRide("西安的年轻人");
        context.freeRide("西安的妇女");
        context.freeRide("西安的儿童");
        context.freeRide("宝鸡的老人");
        context.freeRide("宝鸡的儿童");
    }
}
