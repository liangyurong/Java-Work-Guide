package com.kuang.udp_chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {

    public static void main(String[] args) throws Exception{

        // 建立socket
        DatagramSocket socket = new DatagramSocket();

        // 消息字节数组
        byte[] bytesMsg = "你好啊，服务器".getBytes();

        // 接收地址
        InetAddress address = InetAddress.getByName("127.0.0.1");

        // 接收端口
        int port = 9090;

        // 建立包 (数据 + 数据长度 + 地址 + 端口)
        DatagramPacket datagramPacket = new DatagramPacket(bytesMsg,0,bytesMsg.length,address,port);

        // 发送包
        socket.send(datagramPacket);

        // 关闭流
        socket.close();

    }

}
