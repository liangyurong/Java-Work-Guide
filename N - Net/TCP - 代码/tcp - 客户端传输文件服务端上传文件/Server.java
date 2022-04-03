package com.kuang.tcp_upload_file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args)  throws Exception{

        // 设置服务器地址
        ServerSocket serverSocket = new ServerSocket(9999);

        // 获取连接过来的客户端 （阻塞式监听，会一直等待客户端连接）
        Socket clientSocket = serverSocket.accept();

        // 获取输入流
        InputStream is = clientSocket.getInputStream();

        // 文件
        File file = new File("src/main/java/com/kuang/tcp_upload_file/rece.png");

        // 输出文件
        FileOutputStream fos = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int len ;
        while( (len=is.read(buffer)) != -1 ){
            fos.write(buffer,0,len);
        }

        // 通知客户端，已经接收完毕
        OutputStream os = clientSocket.getOutputStream();
        os.write("服务端已经接收完毕，客户端可以断开链接嘞".getBytes());

        // 关闭资源
        fos.close();
        is.close();
        clientSocket.close();
        serverSocket.close();

    }

}
