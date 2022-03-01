
### 示例

http:localhost:8080/abc?name=?1&age=?2

将name和age封装到map

### 测试

```text
    @GetMapping("test")
    public String forTest(@RequestParam("id")String id,@RequestParam("name")String name){
        return "id="+id+" name="+name;
    }

    // 调用test的get方法
    @GetMapping("testget")
    public String testget(){
        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        map.put("name","yurong333");
        String result =  WebUtils.sendGetByUrlAndMap("http://localhost:8888/test",map);
        return result;
    }
```

### 源码

```java
package com.sdyb.mp.util;

import com.sun.javafx.collections.MappingChange;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.net.URI;
import java.util.HashMap;

import org.apache.http.client.utils.URIBuilder;

public class WebUtils {

    /**
     * 使用httpclient模拟get请求 - 带HashMap参数的get请求
     */
    public static String sendGetByUrlAndMap(String url, Map<String,Object> map) {
            String response = null;
            try {
                CloseableHttpClient httpclient = null;
                CloseableHttpResponse httpresponse = null;
                try {
                    // 获得一个httpclient对象
                    httpclient = HttpClients.createDefault();
    
                    // 定义请求的参数(需要设置param和value)
                    URIBuilder ub = new URIBuilder(url);
                    map.forEach( (k,v) -> ub.setParameter(k,v.toString()));
                    URI uri = ub.build();
    
                    // 创建一个get请求
                    HttpGet httpget = new HttpGet(uri);
    
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
