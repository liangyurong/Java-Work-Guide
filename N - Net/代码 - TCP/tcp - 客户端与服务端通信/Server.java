package com.kuang.tcp_chat1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        // 设置服务器地址(没有设置ip地址，则默认是本机地址)
        ServerSocket serverSocket = new ServerSocket(9999);

        // 获取连接过来的客户端
        Socket clientSocket = serverSocket.accept();

        // 读取客户端传递的消息
        InputStream is = clientSocket.getInputStream();

        // 管道流接收客户端信息（可以防止中文字符过长造成溢出）
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            baos.write(buffer, 0, len);
        }

        // 输出客户端传递的信息
        System.out.println("来自客户端的信息:"+baos.toString());

        // 通知客户端，已经接收完毕
        OutputStream os = clientSocket.getOutputStream();
        os.write("服务端已经接收完毕，客户端可以断开连接".getBytes());

        // 关闭资源
        closeSource(os);
        closeSource(baos);
        closeSource(is);
        closeSource(clientSocket);
        closeSource(serverSocket);

    }

    // 关闭资源（不知道有没有什么问题）
    public static void closeSource(Closeable obj) {
        if (null != obj) {
            try {
                obj.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
