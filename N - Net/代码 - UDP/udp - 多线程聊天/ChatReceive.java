package com.kuang.udp_chat_runnable;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ChatReceive implements Runnable{


    DatagramSocket receiveSocket = null;

    // 接收端口
    private int receivePort;
    // 消息来源方
    private String fromMsg;

    public ChatReceive(int receivePort,String fromMsg) {
        this.receivePort = receivePort;
        this.fromMsg = fromMsg;

        try {
            // 创建Socket
            receiveSocket = new DatagramSocket(receivePort);
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

        // 循环接收包裹
        while (true){
            try{
                // 定义包裹
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);

                // 阻塞式接收包裹
                receiveSocket.receive(packet);

                // 断开连接
                byte[] data = packet.getData();
                String receiveData = new String(data, 0, data.length).trim();

                // 输出接收的消息
                System.out.println("来自"+fromMsg+"的消息："+receiveData);

                if("bye".startsWith(receiveData)){
                    break;
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
