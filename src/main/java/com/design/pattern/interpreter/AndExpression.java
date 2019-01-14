package com.design.pattern.interpreter;

/**
 * @Author: 98050
 * @Time: 2019-01-14 17:04
 * @Feature: 非终结符表达式类
 */
public class AndExpression implements Expression {

    private Expression city=null;
    private Expression person=null;
    public AndExpression(Expression city,Expression person)
    {
        this.city=city;
        this.person=person;
    }

    @Override
    public boolean interpret(String info) {
        String[] s = info.split("的");
        return city.interpret(s[0]) && person.interpret(s[1]);
    }
}
