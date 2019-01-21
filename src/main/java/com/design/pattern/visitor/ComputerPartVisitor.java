package com.design.pattern.visitor;

/**
 * @Author: 98050
 * @Time: 2019-01-21 22:06
 * @Feature:
 */
public interface ComputerPartVisitor {

    void visit(Computer computer);
    void visit(Mouse mouse);
    void visit(Keyboard keyboard);
    void visit(Monitor monitor);

}
