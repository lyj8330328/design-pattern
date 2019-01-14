package com.design.pattern.interpreter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: 98050
 * @Time: 2019-01-14 16:56
 * @Feature: 终结符表达式类
 */
public class TerminalExpression implements Expression{

    private Set<String> set = new HashSet<String>();

    public TerminalExpression(String[] data)
    {
        set.addAll(Arrays.asList(data));
    }

    @Override
    public boolean interpret(String info) {
        if(set.contains(info))
        {
            return true;
        }
        return false;
    }
}
