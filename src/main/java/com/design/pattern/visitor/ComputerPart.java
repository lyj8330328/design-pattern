package com.design.pattern.visitor;

/**
 * @Author: 98050
 * @Time: 2019-01-21 22:05
 * @Feature:
 */
public interface ComputerPart {

    void accept(ComputerPartVisitor computerPartVisitor);
}
