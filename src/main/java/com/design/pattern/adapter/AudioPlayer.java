package com.design.pattern.adapter;

/**
 * @Author: 98050
 * @Time: 2019-02-24 17:27
 * @Feature:
 */
public class AudioPlayer implements MediaPlayer {

    private MediaAdapter mediaAdapter;

    @Override
    public void play(String type, String name) {
        //播放mp3，内置支持
        if (type.equalsIgnoreCase("mp3")){
            System.out.println("play mp3：" + name);
        }else if (type.equalsIgnoreCase("vlc") || type.equalsIgnoreCase("mp4")){
            mediaAdapter = new MediaAdapter(type);
            mediaAdapter.play(type, name);
        }else {
            System.out.println("invalid media type");
        }
    }
}
