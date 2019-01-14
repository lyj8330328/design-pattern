package com.design.pattern.builder.stringbuilder;

import java.util.Arrays;

/**
 * @Author: 98050
 * @Time: 2019-01-11 15:58
 * @Feature:
 */
public class Test {


    public static void main(String[] args) {
        MyStringBuilder stringBuilder = new MyStringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append((char)('0' + i));
        }
        System.out.println(stringBuilder.toString());

        String string = "1";
        string.concat("2");
    }
}
