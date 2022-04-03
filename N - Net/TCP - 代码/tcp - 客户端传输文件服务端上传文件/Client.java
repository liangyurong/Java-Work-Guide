package com.kuang.tcp_upload_file;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception{

        // 获取服务器地址
        InetAddress serverIp = InetAddress.getByName("127.0.0.1");

        // 服务器的端口号
        int port = 9999;

        // 创建Socket连接
        Socket clientSocket = new Socket(serverIp, port);

        // 创建输出流
        OutputStream os = clientSocket.getOutputStream();

        // 文件
        String pathName = "src/main/java/com/kuang/tcp_upload_file/huya.png";
        File file = new File(pathName);

        // 读取文件
        FileInputStream fis = new FileInputStream(file);

        // 输出文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }

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
        System.out.println("服务器接收完信息，传递给客户端的消息："+ baos.toString());

        // 关闭资源
        fis.close();
        os.close();
        clientSocket.close();

    }

}
