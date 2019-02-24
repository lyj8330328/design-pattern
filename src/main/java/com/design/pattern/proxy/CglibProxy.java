package com.design.pattern.proxy;

import org.mockito.cglib.proxy.Enhancer;
import org.mockito.cglib.proxy.MethodInterceptor;
import org.mockito.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: 98050
 * @Time: 2019-02-17 22:28
 * @Feature: CGLIB动态代理
 */
public class CglibProxy implements MethodInterceptor {

    /**
     * 这里的目标类型为Object，则可以接受任意一种参数作为被代理类，实现了动态代理
     */
    private Object targetObject;

    public Object getInstance(Object target) {
        // 设置需要创建子类的类
        this.targetObject = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLIB动态代理开启事务");
        Object result = methodProxy.invoke(targetObject, objects);
        System.out.println("CGLIB动态代理提交事务");
        // 返回代理对象
        return result;
    }
}
