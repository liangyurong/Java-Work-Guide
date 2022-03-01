
### 说明

请求体是json

### 扩展

即使是加密后的json字符串，也是直接写在body即可

### 封装json请求参数

首先使用HashMap封装多个请求参数

然后使用String json = JSONObject.toJSONString(paramMap)，转为json

再放入请求body

### 接口接收json请求体的请求

使用@RequestBody接收

### 源码

```java
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hutool")
public class TestPost {

    @PostMapping("hutoolPost1")
    public String testPost(@RequestBody JSONObject json){
        return "id="+json.getString("id")+" name="+ json.getString("name");
    }

    // 请求是json
    @GetMapping("testPost1")
    public String testpost1(){

        // 请求路径
        String url = "http://localhost:8888/hutool/hutoolPost1";

        // map封装请求参数
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("id",1);
        paramMap.put("name","yurong123");

        // 将map转为json形式的字符串
        String json = JSONObject.toJSONString(paramMap);

         HttpResponse response= HttpRequest.post(url)
                // .header("","") // 添加请求头
                .body(json)
                .timeout(20000)
                .execute();
        String result = response.body();
        return result;

    }

}

```
