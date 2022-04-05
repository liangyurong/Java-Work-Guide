package com.kuang.tcp_chat1;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception{
        // 获取服务器地址
        InetAddress serverIp = InetAddress.getByName("127.0.0.1");

        // 服务器的端口号
        int port = 9999;

        // 创建客户端Socket连接
        Socket clientSocket = new Socket(serverIp, port);

        // 设置超时时间 = 3000ms
        clientSocket.setSoTimeout(3000);

        // 客户端输出流
        OutputStream os = clientSocket.getOutputStream();

        // 写入消息
        String msg = "你好，服务端";
        os.write(msg.getBytes());

        // 通知服务器，已经传输完了
        clientSocket.shutdownOutput();

        // 确定服务器接收完毕，才能断开链接
        InputStream inputStream = clientSocket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer2 = new byte[1024];
        int len2;
        while ((len2 = inputStream.read(buffer2)) != -1){
            baos.write(buffer2,0,len2);
        }
        System.out.println("来自服务端的信息："+ baos.toString());

        // 关闭资源(哪些需要释放)
        baos.close();
        inputStream.close();
        os.close();
        clientSocket.close();
    }
}
