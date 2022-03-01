
```java
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/hutool")
public class TestPost {
    
     // 被调用的接口
     @PostMapping("hutoolPost1")
     public String testPost(@RequestBody JSONObject json){
          return "id="+json.getString("id")+" name="+ json.getString("name");
     }

    // 请求是json
    @GetMapping("testPost2")
    public String testpost2(){

    // 请求路径
        String url = "http://localhost:8888/hutool/hutoolPost1";

        // json封装请求参数
        JSONObject json = new JSONObject();
        json.put("id",1);
        json.put("name","yurong123");

        // 将json转为json形式的字符串
        String jsonStr = json.toJSONString();

        HttpResponse response = HttpRequest.post(url)
                // .header("","") // 添加请求头
                .body(jsonStr)
                .timeout(20000)
                .execute();
        // 请求内容
        String result = response.body();
        return result;

    }
    
}
```
