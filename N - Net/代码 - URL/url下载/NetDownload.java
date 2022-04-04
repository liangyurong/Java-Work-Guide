package com.kuang.url_download;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class NetDownload {

    public static void main(String[] args) throws Exception {
        // 下载地址
        String urlPath="https://static.is26.com/blog/2018/10/desk/desk-25.JPG";

        // 创建URL
        URL url = new URL(urlPath);

        // 打开连接
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();

        // 输入流
        InputStream is = connection.getInputStream();

        // 输入流转为一个文件
        FileOutputStream fos = new FileOutputStream("output.jpg");
        byte[] buffer = new byte[1024];
        int len;
        while ((len=is.read(buffer))!= -1){
            fos.write(buffer,0,len);
        }

        // 关闭
        fos.close();
        is.close();
        connection.disconnect();

    }
}
