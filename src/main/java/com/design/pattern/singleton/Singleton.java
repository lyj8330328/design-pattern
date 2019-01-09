package com.design.pattern.singleton;

/**
 * @Author: 98050
 * @Time: 2019-01-09 22:39
 * @Feature: 懒汉式-线程不安全
 */
public class Singleton {

    private static Singleton uniqueInstance;

    private Singleton(){
        System.out.println("运行");
    }

    public static Singleton getUniqueInstance() {
        if (uniqueInstance == null){
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

}

