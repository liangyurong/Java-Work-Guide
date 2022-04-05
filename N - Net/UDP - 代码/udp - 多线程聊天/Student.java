package com.kuang.udp_chat_runnable;

public class Student {
    public static void main(String[] args) {

        // 为什么一个类开两个线程？因为你既要发送信息也要接收信息
        // 发送和接收都是针对对方的

        // fromPort、receivePort是线程端口

        // 从7777端口发送消息给9999端口
        new Thread(new ChatSend(7777,"localhost",9999)).start();
        // 在8888端口接收来自老师的信息
        new Thread(new ChatReceive(8888,"老师")).start();
    }
}
