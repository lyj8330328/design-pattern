package com.design.pattern.builder.stringbuilder;

import java.util.Arrays;

/**
 * @Author: 98050
 * @Time: 2019-01-11 15:35
 * @Feature:
 */
public class MyAbstractStringBuilder {

    char[] value;
    int count;

    public MyAbstractStringBuilder(int capacity){
        count = 0;
        value = new char[capacity];
    }

    public MyAbstractStringBuilder append(char c){
        ensureCapacityInternal(count + 1);
        value[count ++] = c;
        return this;
    }

    private void ensureCapacityInternal(int minimumCapacity) {
        // overflow-conscious code
        if (minimumCapacity - value.length > 0) {
            //扩容
            expandCapacity(minimumCapacity);
        }
    }

    private void expandCapacity(int minimumCapacity) {
        int newCapacity = (value.length << 1) + 2;
        if (newCapacity - minimumCapacity < 0) {
            newCapacity = minimumCapacity;
        }
        if (newCapacity < 0){
            if (minimumCapacity < 0){
                throw new OutOfMemoryError();
            }
            newCapacity = Integer.MAX_VALUE;
        }
        value = Arrays.copyOf(value, newCapacity);
    }
}
