package com.kuang.udp_chat_runnable;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ChatSend implements Runnable {

    // 发送端口
    private int fromPort;

    // 接收ip
    private String toIp;

    // 接收端口
    private int toPort;

    DatagramSocket sendSocket = null;

    BufferedReader reader = null;

    public ChatSend(int fromPort, String toIp, int toPort) {
        this.fromPort = fromPort;
        this.toIp = toIp;
        this.toPort = toPort;

        try {
            // 创建Socket
            sendSocket = new DatagramSocket(fromPort);
            // 从控制台读取数据
            reader = new BufferedReader(new InputStreamReader(System.in));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // 循环发送消息
        while (true) {
            try{
                // 将字符流转为字节流
                String data = reader.readLine();
                byte[] dataBytes = data.getBytes();

                // 接收地址 接收端口
                InetAddress address = InetAddress.getByName(toIp);

                // 建立发送包
                DatagramPacket packet = new DatagramPacket(dataBytes, 0, dataBytes.length, address,toPort);

                // 发送包
                sendSocket.send(packet);

                // 退出循环(发送完包才退出)
                if("bye".equals(data)){
                    break;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        // 关闭资源
        sendSocket.close();
    }

}
