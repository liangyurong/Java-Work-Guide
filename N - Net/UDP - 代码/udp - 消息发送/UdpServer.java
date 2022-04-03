package com.kuang.udp_chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer {

    public static void main(String[] args) throws Exception{

        // 开放端口
        DatagramSocket socket = new DatagramSocket(9090);

        // 接收数据包
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        socket.receive(packet); // 阻塞接收

        // 输出接收的消息(需要长度)
        String receiveMsg = new String(packet.getData(),0,packet.getLength());
        System.out.println(receiveMsg);

        // 关闭连接
        socket.close();

    }

}
