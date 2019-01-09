package com.design.pattern.singleton;

/**
 * @Author: 98050
 * @Time: 2019-01-09 23:03
 * @Feature: 双重校验锁-线程安全
 */
public class Singleton4 {
    private static volatile Singleton4 uniqueInstance;

    private Singleton4(){
        System.out.println("运行");
    }

    public static Singleton4 getUniqueInstance() {
        if (uniqueInstance == null){
            synchronized (Singleton4.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton4();
                }
            }
        }
        return uniqueInstance;
    }
}
