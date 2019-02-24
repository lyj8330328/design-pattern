package com.design.pattern.adapter;

/**
 * @Author: 98050
 * @Time: 2019-02-24 17:22
 * @Feature:
 */
public class MediaAdapter implements MediaPlayer {

    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String type) {
        if (type.equalsIgnoreCase("vlc")){
            advancedMediaPlayer = new VlcPlayer();
        }else if (type.equalsIgnoreCase("mp4")){
            advancedMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String type, String name) {
        if (type.equalsIgnoreCase("vlc")){
            advancedMediaPlayer.playVlc(name);
        }else if (type.equalsIgnoreCase("mp4")){
            advancedMediaPlayer.playMp4("mp4");
        }
    }
}
