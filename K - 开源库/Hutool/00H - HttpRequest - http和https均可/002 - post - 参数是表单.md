
### 构建的post请求

http://localhost:8888/hutool/hutoolPost？id=1&name=yurong

### 被调用接口去接收参数

@RequestParam接收参数

### 源码

```java
package com.sdyb.mp.module.hutool.controller;

import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hutool")
public class TestWeb {

    // 被测试的
    @PostMapping("hutoolPost")
    public String testPost(@RequestParam("id")String id,@RequestParam("name")String name){
        return "id="+id+" name="+name;
    }

    // 普通表单
    @GetMapping("testPost")
    public String testpost(){

        // 请求路径
        String url = "http://localhost:8888/hutool/hutoolPost";
        
        // 请求参数
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("id",1);
        paramMap.put("name","yurong");

         HttpResponse response = HttpRequest.post(url)
                .header(Header.USER_AGENT, "Hutool http")//头信息，多个头信息多次调用此方法即可
                // .header("","") // 请求头，其他参数
                .form(paramMap)//表单内容
                .timeout(20000)//超时，毫秒
                .execute();
        
        // 通过链式构建请求，我们可以很方便的指定Http头信息和表单信息，最后调用execute方法即可执行请求，返回HttpResponse对象。
        String result = response.body();
        
        return result;

    }

}

```
