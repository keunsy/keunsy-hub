package com.keunsy.hub.core.designpattern.structure.adapter;

public class Adapter {

  public static void main(String[] args) {
    //兼容了高级功能的普通播放器
    Player player = new Player();
    player.play();
  }
}

//普通的播放器
interface MediaPlayer {
  public void play();
}

//高级的播放器
interface AdvanceMediaPlayer {
  public void playVideo();
}

//视频播放器（高级的播放器）
class VideoPlayer implements AdvanceMediaPlayer {
  @Override
  public void playVideo() {
    System.out.println("play video!");
  }
}

//适配器(衔接了普通播放器与高级播放器这两个独立接口的功能)
class MediaAdapter implements MediaPlayer {
  AdvanceMediaPlayer advanceMediaPlayer;

  public MediaAdapter() {
    advanceMediaPlayer = new VideoPlayer();
  }

  @Override
  public void play() {
    advanceMediaPlayer.playVideo();
  }
}

//普通播放器
class Player implements MediaPlayer {
  //兼容高级播放器的适配器
  MediaAdapter mediaAdapter = new MediaAdapter();

  @Override
  public void play() {
    mediaAdapter.play();
  }
}