package com.design.pattern;

import java.util.Calendar;

/**
 * @Author: 98050
 * @Time: 2019-01-09 22:38
 * @Feature:
 */
public class Test {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        System.out.println(calendar.hashCode());
        System.out.println(calendar2.hashCode());
    }
}
