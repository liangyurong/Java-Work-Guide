package com.lyr.demo.decorate;

public class TestMain {
    public static void main(String[] args) {
        // 通过适配器播放不同的音乐文件
        MusicPlayer player = new PlayerAdapter();
        player.play("mp3","xxx.mp3");
        player.play("wma","xxx.wma");
    }
}
