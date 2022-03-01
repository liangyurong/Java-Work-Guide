package com.lyr.demo.decorate;

/**
 * 适配器实现类
 */
public class PlayerAdapter implements MusicPlayer {

    // 播放器
    private MyPlayer myPlayer;

    // 构造的时候得创建适配器
    public PlayerAdapter(){
        this.myPlayer = new MyPlayer();
    }

    /**
     * 适配器方法
     * @param type 音乐类型
     * @param fileName 文件路径
     */
    @Override
    public void play(String type, String fileName) {
       if("mp3".equals(type)){
         this.myPlayer.playMp3(fileName);
       }

       if("wma".equals(type)){
           this.myPlayer.playWma(fileName);
       }
    }
}
