package com.design.pattern.templatemethod;

/**
 * @Author: 98050
 * @Time: 2019-01-20 18:09
 * @Feature:
 */
public abstract class Game {

    /**
     * 初始化游戏
     */
    abstract void initialize();

    /**
     * 开始游戏
     */
    abstract void startPlay();

    /**
     * 结束游戏
     */
    abstract void endPlay();

    /**
     * 模板
     */
    public final void play(){

        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }
}
