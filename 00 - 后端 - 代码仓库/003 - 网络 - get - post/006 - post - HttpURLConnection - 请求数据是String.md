


## 使用HttpURLConnection


### 测试

String params应该怎么搞？

### 源码

```jshelllanguage

import java.io.*;
import java.net.*;

 /**
     * 使用HttpURLConnection向指定 URL 发送POST方法的请求
     *
     * @param url 发送请求的 URL
     * @param params 请求参数，请求参数应该是 ?name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String toSendPost(String url, String params)throws IOException{
        OutputStreamWriter out = null;
        BufferedReader reader = null;
        String response="";
        try {
            URL httpUrl =  new URL(url);
            HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();  //建立连接
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("connection", "keep-alive");
            conn.setUseCaches(false);//设置不要缓存
            conn.setInstanceFollowRedirects(true);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();
            //POST请求
            out = new OutputStreamWriter(conn.getOutputStream());
            out.write(params);
            out.flush();
            //读取响应
            reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String lines;
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                response+=lines;
            }
            reader.close();
            // 断开连接
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(reader!=null){
                    reader.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }

        return response;
    }

```

