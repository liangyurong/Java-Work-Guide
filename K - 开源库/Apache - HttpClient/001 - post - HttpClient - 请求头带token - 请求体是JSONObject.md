## 注意

post请求头带上accesstoken

请求数据是json

请求结果是String字符串

### 依赖

```xml
<dependency>
    <groupId>org.apache.httpcomponents</groupId>
    <artifactId>httpclient</artifactId>
    <version>4.5.13</version>
</dependency>
```

### 测试

已测试成功：在罗湖人民医院艾乙梅数据上报项目

```jshelllanguage
    @GetMapping("/qq")
    public String url(){
    
        String aiyimeiUrl = "www.baidu.com";
        String token = "wefqsafscadsfw";
    
        JSONObject json = new JSONObject();
        json.put("EpisodeIDs","15561825");
        
        return  WebUtils.sendPost(aiyimeiUrl, encryptJson,token);
    }
```

### 设置请求头带accesstoken，设置请求体为json

```java
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 网络工具
 */
public class WebUtils {

    /**
     * 使用httpclient模仿post请求
     * @param url post链接
     * @param data json格式的String字符串
     * @param token token
     * @return 返回post结果
     */
    public static String sendPost(String url, String data,String token) {
        String response = null;
        try {
            CloseableHttpClient httpclient = null;
            CloseableHttpResponse httpresponse = null;
            try {
                
                // 获得一个httpclient对象
                httpclient = HttpClients.createDefault();
                
                // 生成一个post请求
                HttpPost httppost = new HttpPost(url);

                // 请求头携带token (这里的参数得看第三方的token字段是啥，不一定是AccessToken)
                httppost.addHeader("token",token);
                
                // 请求体设置为json
                httppost.addHeader("Content-Type", "application/json");

                // 设置请求体
                StringEntity stringentity = new StringEntity(data);
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


}


```
