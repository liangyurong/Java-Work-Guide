package com.kuang.tcp_chat;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try {
            // 设置服务器地址
            serverSocket = new ServerSocket(9999);

            // 获取连接过来的客户端
            clientSocket = serverSocket.accept();

            // 读取客户端传递的消息
            is = clientSocket.getInputStream();

            // 管道流接收客户端信息（可以防止中文字符过长造成溢出）
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len=is.read(buffer))!=-1){
                baos.write(buffer,0,len);
            }

            // 输出客户端传递的信息
            System.out.println(baos.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 关闭资源
            closeSource(baos);
            closeSource(is);
            closeSource(clientSocket);
            closeSource(serverSocket);
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

//            if(null != baos){
//                try {
//                    baos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            if(null != is){
//                try {
//                    is.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            if(null != clientSocket){
//                try {
//                    clientSocket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            if(null != serverSocket){
//                try {
//                    serverSocket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
