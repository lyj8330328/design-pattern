package com.design.pattern.proxy;

/**
 * @Author: 98050
 * @Time: 2019-02-17 22:05
 * @Feature:
 */
public class UserServiceProxy {

    private UserService service;

    public UserServiceProxy(UserService service) {
        this.service = service;
    }

    public void add(){
        System.out.println("静态代理：开启事务");
        service.add();
        System.out.println("静态代理：提交事务");
    }
}
