package com.design.pattern.iterator;

/**
 * @Author: 98050
 * @Time: 2019-01-14 17:40
 * @Feature:
 */
public class MyContainer implements Container {

    public String[] strings = new String[]{"123","456","789"};

    @Override
    public Iterator getIterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator{

        int index;

        @Override
        public boolean hasNext() {
            return index < strings.length;
        }

        @Override
        public Object next() {
            return this.hasNext() ? strings[index ++] : null;
        }
    }
}
