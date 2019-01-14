package com.design.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 98050
 * @Time: 2019-01-14 17:43
 * @Feature:
 */
public class Test {

    public static void main(String[] args) {
        MyContainer container = new MyContainer();
        Iterator iterator = container.getIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        List<String> list = new ArrayList<String>();
        list.iterator();
    }

}
