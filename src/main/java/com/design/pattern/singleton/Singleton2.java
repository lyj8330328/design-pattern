package com.design.pattern.singleton;

/**
 * @Author: 98050
 * @Time: 2019-01-09 23:03
 * @Feature: 饿汉式-线程安全
 */
public class Singleton2 {

    private static Singleton2 uniqueInstance = new Singleton2();

    private Singleton2(){
        System.out.println("运行");
    }

    public static Singleton2 getUniqueInstance() {
        return uniqueInstance;
    }
}
