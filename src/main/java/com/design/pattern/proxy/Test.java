package com.design.pattern.proxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 98050
 * @Time: 2019-02-17 22:07
 * @Feature:
 */
public class Test {

    public static void main(String[] args) {
        /**
         * 静态代理
         */
        UserService userService = new UserServiceImpl();
        UserServiceProxy userServiceProxy = new UserServiceProxy(userService);
        userServiceProxy.add();

        System.out.println("-------------------------------------------");

        /**
         * 动态代理
         */
        InvocationHandlerImpl invocationHandler = new InvocationHandlerImpl(userService);
        ClassLoader loader = userService.getClass().getClassLoader();
        Class<?>[] interfaces = userService.getClass().getInterfaces();
        UserService newProxy = (UserService) Proxy.newProxyInstance(loader, interfaces, invocationHandler);
        newProxy.add();

        System.out.println("-------------------------------------------");

        /**
         * CGLIB动态代理
         */
        CglibProxy cglibProxy = new CglibProxy();
        UserService userService1 = (UserService) cglibProxy.getInstance(new UserServiceImpl());
        userService1.add();

    }
}
