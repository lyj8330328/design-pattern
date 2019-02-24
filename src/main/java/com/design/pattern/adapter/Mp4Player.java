package com.design.pattern.adapter;

/**
 * @Author: 98050
 * @Time: 2019-02-24 17:19
 * @Feature:
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playMp4(String name) {
        System.out.println("play mp4：" + name);
    }

    @Override
    public void playVlc(String name) {

    }
}
