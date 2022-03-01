
### 说明

不需要添加其他依赖

模仿浏览器发出get请求

````java
package com.sdyb.orderwechatpay.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Test {

    // 需要自定义一个有效的url
    private static String url = "http://134.175.207.83:8078/hi";
    private static String charset = "UTF-8";
    private static int timeout = 1000;

    public static void main(String[] args) {
        System.out.println(Test.toSendGet(url,charset,timeout));
    }

    /***
     * 模拟get请求
     */
    public static String toSendGet(String url, String charset, int timeout) {
        String result = "";
        try {
            URL u = new URL(url);
            try {
                URLConnection conn = u.openConnection();
                conn.connect();
                conn.setConnectTimeout(timeout);
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
                String line = "";
                while ((line = in.readLine()) != null) {
                    result = result + line;
                }
                in.close();
            } catch (IOException e) {
                return result;
            }
        } catch (MalformedURLException e) {
            return result;
        }
        return result;
    }

}

````
