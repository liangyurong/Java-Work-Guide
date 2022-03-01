### 关键词
json,json取值，取json里面的数组

### 一、说明

1、从JSONObject取出JSONArray
	 
2、从JSONArray中取出JSONObject


### 三、postman中传值

1、整体是JSONObject结构，key是options，value是后面的数组。

2、通过getJSONArray("options");可以取到后面的数组。

```json
{
    "options": [
                {
                    "optionContent": "选项内容1"
                },
                {
                    "optionContent": "选项内容2"
                },
                {
                    "optionContent": "选项内容3"
                }
            ]
}
```
### 四、正确代码

```java
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @ResponseBody
    @PostMapping("/test")
    public JSONObject test(@RequestBody JSONObject json){
        JSONArray array=json.getJSONArray("options");
        
        JSONObject jsonObject=new JSONObject();
        for (int i = 0,size=array.size(); i <size ; i++) {
            JSONObject jsonObject1 = array.getJSONObject(i);
            // String字符串，就使用getString()
            String content = jsonObject1.getString("optionContent");
            jsonObject.put("optionName"+i,content);
        }
        return jsonObject;
    }

}
```

### 五、正确结果

![](https://github.com/liangyurong/imageHouse/blob/master/%E5%9B%BE%E7%89%87%E5%BA%93/011.png)

### 六、错误代码

```java
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @ResponseBody
    @PostMapping("/test")
    public JSONObject test(@RequestBody JSONObject json) {
        JSONArray array = json.getJSONArray("options");
        JSONObject jsonObject = null;
        for (int i = 0; i < array.size(); i++) {
            String optionName = JSON.parseObject(array.get(i).toString()).getString("optionContent");
            jsonObject.put("option" + i, optionName);
        }
        return jsonObject;
    }
    
}
```
### 七、错误代码的原因分析

报错信息：com.alibaba.fastjson.JSONException: expect ':' at 0, actual =

问题代码：JSON.parseObject(array.get(i).toString()); 

原因：转换的过程中，toString()方法将符号 : 转为了 = 。
