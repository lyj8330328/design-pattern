package com.design.pattern.iterator;

/**
 * @Author: 98050
 * @Time: 2019-01-14 17:36
 * @Feature: 迭代器接口
 */
public interface Iterator {

    /**
     * 是否存在下一个元素
     * @return
     */
    boolean hasNext();

    /**
     * 获取下一个元素
     * @return
     */
    Object next();
}
