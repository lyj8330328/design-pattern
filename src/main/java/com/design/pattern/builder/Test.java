package com.design.pattern.builder;

/**
 * @Author: 98050
 * @Time: 2019-01-11 15:21
 * @Feature:
 */
public class Test {

    public static void main(String[] args) {
        User2 user2 = new User2.Builder().setName("1").setAge(2).build();

        StringBuilder stringBuilder = new StringBuilder();
        final int count = 26;
        for (int i = 0; i < count; i++) {
            stringBuilder.append((char) ('a' + i));
        }
        System.out.println(stringBuilder.toString());

    }
}
