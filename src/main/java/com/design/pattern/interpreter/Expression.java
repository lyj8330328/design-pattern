package com.design.pattern.interpreter;

/**
 * @Author: 98050
 * @Time: 2019-01-14 16:53
 * @Feature: 抽象表达式
 */
public interface Expression {

    boolean interpret(String info);
}
