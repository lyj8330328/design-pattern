package com.design.pattern.adapter;

/**
 * @Author: 98050
 * @Time: 2019-02-24 17:17
 * @Feature:
 */
public interface AdvancedMediaPlayer {
    /**
     * 播放mp4
     * @param name
     */
    void playMp4(String name);

    /**
     * 播放vlc
     * @param name
     */
    void playVlc(String name);
}
