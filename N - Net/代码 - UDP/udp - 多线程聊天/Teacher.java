package com.kuang.udp_chat_runnable;

public class Teacher {
    public static void main(String[] args) {
        // 从5555端口发送消息给8888端口
        new Thread(new ChatSend(5555,"localhost",8888)).start();
        // 在9999端口接收来自学生的信息
        new Thread(new ChatReceive(9999,"学生")).start();
    }
}
