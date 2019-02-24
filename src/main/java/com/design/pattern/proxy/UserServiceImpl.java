package com.design.pattern.proxy;

/**
 * @Author: 98050
 * @Time: 2019-02-17 22:04
 * @Feature:
 */
public class UserServiceImpl implements UserService {

    @Override
    public void add() {
        System.out.println("添加数据");
    }
}
