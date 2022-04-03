package com.kuang.tcp_chat;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClient {

    public static void main(String[] args) {

        Socket clientSocket = null;
        OutputStream os = null;

        try {
            // 获取服务器地址
            InetAddress serverIp = InetAddress.getByName("127.0.0.1");

            // 服务器的端口号
            int port = 9999;

            // 创建客户端Socket连接
            clientSocket = new Socket(serverIp,port);

            // 发送消息 - 使用IO流
            os = clientSocket.getOutputStream();
            String msg = "你好，服务端。我是客户端，正在向您发送消息、、、";
            os.write(msg.getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeSource(os);
            closeSource(clientSocket);
        }

    }

    // 关闭资源（不知道有没有什么问题）
    public static void closeSource(Closeable obj){
        if(null != obj){
            try {
                obj.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
