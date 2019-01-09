package com.design.pattern.singleton;

/**
 * @Author: 98050
 * @Time: 2019-01-09 23:03
 * @Feature: 懒汉式-线程安全
 */
public class Singleton3 {

    private static Singleton3 uniqueInstance;

    private Singleton3(){
        System.out.println("运行");
    }

    public static synchronized Singleton3 getUniqueInstance() {
        if (uniqueInstance == null){
            uniqueInstance = new Singleton3();
        }
        return uniqueInstance;
    }
}
