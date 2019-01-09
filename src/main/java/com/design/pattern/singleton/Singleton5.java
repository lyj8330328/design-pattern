package com.design.pattern.singleton;

/**
 * @Author: 98050
 * @Time: 2019-01-09 23:04
 * @Feature: 静态内部类实现
 */
public class Singleton5 {

    private Singleton5(){
        System.out.println("运行");
    }
    private static class Singleton5Holder{
        private static final Singleton5 uniqueInstance = new Singleton5();
    }

    public static Singleton5 getUniqueInstance() {

        return Singleton5Holder.uniqueInstance;
    }
}
