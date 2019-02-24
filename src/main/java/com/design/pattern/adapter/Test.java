package com.design.pattern.adapter;

import java.util.Arrays;

/**
 * @Author: 98050
 * @Time: 2019-02-24 17:30
 * @Feature:
 */
public class Test {

    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "123");
        audioPlayer.play("mp4", "321");
        audioPlayer.play("vlc", "456");
        audioPlayer.play("mp5", "654");
    }
}
