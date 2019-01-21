package com.design.pattern.visitor;

/**
 * @Author: 98050
 * @Time: 2019-01-21 22:08
 * @Feature:
 */
public class Computer implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
