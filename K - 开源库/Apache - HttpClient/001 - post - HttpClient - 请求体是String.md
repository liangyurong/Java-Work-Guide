## 方法二：使用httpclient实现post请求方法

### 此方法需要添加的依赖

```xml
<dependency>
    <groupId>org.apache.httpcomponents</groupId>
    <artifactId>httpclient</artifactId>
    <version>4.5.13</version>
</dependency>

```

### 测试

未测试

### 源码

```jshelllanguage
import java.io.*;
import java.net.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

 /**
     * 使用httpclient实现post请求方法
     * @param url
     * @param data
     * @return
     */
    public String sendPost1(String url, String data) {
        String response = null;
        try {
            CloseableHttpClient httpclient = null;
            CloseableHttpResponse httpresponse = null;
            try {
                httpclient = HttpClients.createDefault();
                HttpPost httppost = new HttpPost(url);
                
                // 设置请求头，请求头携带token (如果有token可以添加token)
                // httppost.addHeader("AccessToken",WebUtils.getAccessToken());
                
                // 设置请求体
                StringEntity stringentity = new StringEntity(data, ContentType.create("text/json", "UTF-8"));
                httppost.setEntity(stringentity);
                
                // 响应内容
                httpresponse = httpclient.execute(httppost);
                
                response = EntityUtils.toString(httpresponse.getEntity());
            } finally {
                if (httpclient != null) {
                    httpclient.close();
                }
                if (httpresponse != null) {
                    httpresponse.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
```

