package com.design.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: 98050
 * @Time: 2019-02-17 22:22
 * @Feature: JDK动态代理
 */
public class InvocationHandlerImpl implements InvocationHandler {

    private Object target;

    public InvocationHandlerImpl(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("JDK动态代理 开启事务");
        result = method.invoke(target,args);
        System.out.println("JDK动态代理 提交事务");
        return result;
    }
}
