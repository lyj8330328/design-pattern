package com.design.pattern.state;

/**
 * @Author: 98050
 * @Time: 2019-01-18 22:16
 * @Feature:
 */
public class Test {

    public static void main(String[] args) {
        Context context = new Context();
        StartState startState = new StartState();
        startState.doAction(context);
        System.out.println(context.getState());

        StopState stopState = new StopState();
        stopState.doAction(context);
        System.out.println(context.getState());
    }
}
