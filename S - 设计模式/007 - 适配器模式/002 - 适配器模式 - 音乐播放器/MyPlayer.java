package com.lyr.demo.decorate;

/**
 * 播放器，需要支持mp3和wma格式，因此得需要使用适配器
 */
public class MyPlayer {

    public void playMp3(String fileName){
        System.out.println("play mp3" + fileName);
    }

    public void playWma(String fileName){
        System.out.println("play wma" + fileName);
    }

}
