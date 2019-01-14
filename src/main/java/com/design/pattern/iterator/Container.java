package com.design.pattern.iterator;

/**
 * @Author: 98050
 * @Time: 2019-01-14 17:37
 * @Feature: 容器类接口
 */
public interface Container {

    /**
     * 获取迭代器
     * @return
     */
    Iterator getIterator();
}
