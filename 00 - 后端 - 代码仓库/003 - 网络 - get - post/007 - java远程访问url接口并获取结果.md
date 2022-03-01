
### 源码

```java
package com.sdyb.orderwechatpay.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Test {

    /**
     * 向远程接口发起请求，返回字符串类型结果
     * @param url 接口地址
     * @param requestMethod 请求方式
     * @param params 传递参数     重点：参数值需要用Base64进行转码
     * @return String 返回结果
     */
    public static String httpRequestToStringOne(String url, String requestMethod,Map<String, String> params){
        String result = null;
        try {
            InputStream is = httpRequestToStream(url, requestMethod, params);
            byte[] b = new byte[is.available()];
            is.read(b);
            result = new String(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 向远程接口发起请求，返回字符串类型结果
     * @param url 接口地址
     * @param requestMethod 请求方式
     * @param params 传递参数  重点：参数值需要用Base64进行转码
     * @return
     */
    public static String httpRequestToString(String url, String requestMethod, Map params) {
        String result = null;
        try {
            InputStream is = httpRequestToStream(url,requestMethod,  params);
            BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = in.readLine()) != null) {
                buffer.append(line);
            }
            result = buffer.toString();
        } catch (Exception e) {
            return null;
        }
        return result;
    }

    /**
     *  向远程接口发起get请求，返回字节流类型结果
     *  @param url 接口地址
     *  @param requestMethod 请求方式
     *  @param params 传递参数   重点：参数值需要用Base64进行转码
     *  @return InputStream 返回结果
     */
    private static InputStream httpRequestToStream(String url, String requestMethod,Map params) {
        InputStream is = null;
        try {
            String parameters = "";
            boolean hasParams = false;
            //将参数集合拼接成特定格式，如name=zhangsan&age=24
            for(Object key : params.keySet()){
                String value = URLEncoder.encode((String)params.get(key), "UTF-8");
                parameters += key +"="+ value +"&";
                hasParams = true;
            }
            if(hasParams){
                parameters = parameters.substring(0, parameters.length()-1);
            }

            //请求方式是否为get
            boolean isGet = "get".equalsIgnoreCase(requestMethod);
            //请求方式是否为post
            boolean isPost = "post".equalsIgnoreCase(requestMethod);
            if(isGet){
                url += "?"+ parameters;
            }

            URL u = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); //请求的参数类型
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setRequestProperty("contentType", "utf-8");
            conn.setConnectTimeout(50000);//设置连接超时时间
            conn.setReadTimeout(50000);//设置读取返回内容超时时间
            if(isPost){ //设置向HttpURLConnection对象中输出，因为post方式将请求参数放在http正文内，因此需要设置为ture，默认false
                conn.setDoOutput(true);
            }
            conn.setDoInput(true); //设置从HttpURLConnection对象读入，默认为true
            //设置是否使用缓存，post方式不能使用缓存
            if(isPost){
                conn.setUseCaches(false);
            }
            conn.setRequestMethod(requestMethod); //设置请求方式

            //post方式需要将传递的参数输出到conn对象中
            if(isPost){
                DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
                dos.writeBytes(parameters);
                dos.flush();
                dos.close();
            }

            is = conn.getInputStream();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return is;
    }

}

```

### 使用例子





