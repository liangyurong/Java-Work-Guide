


### 依赖

```xml
<dependency>
    <groupId>org.apache.httpcomponents</groupId>
    <artifactId>httpclient</artifactId>
    <version>4.5.13</version>
</dependency>
```

### 测试

已在实际项目测试

```jshelllanguage
String url = "www.zhihu.com";
String result = WebUtils.sendGet(url);
```

### 源码

```jshelllanguage
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class WebUtils {
    
     /**
         * 使用httpclient模拟get请求 - 普通无参数get请求
         */
        public static String sendGet(String url) {
            String response = null;
            try {
                CloseableHttpClient httpclient = null;
                CloseableHttpResponse httpresponse = null;
                try {
                    // 获得一个httpclient对象
                    httpclient = HttpClients.createDefault();
                    // 创建一个get请求
                    HttpGet httpget = new HttpGet(url);
    
                    // 响应内容
                    httpresponse = httpclient.execute(httpget);
    
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

}
```
