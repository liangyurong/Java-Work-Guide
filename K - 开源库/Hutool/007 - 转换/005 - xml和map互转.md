
```java
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import java.util.HashMap;
import java.util.Map;


public class TestJSon2Xml {

  public static void main(String[] args) {

    Map<String, Object> map = new HashMap<>();
    map.put("name", "yurong123");
    map.put("age", 25);

    String s = map2Xml(map);

    Map<String, Object> map1 = xml2Map(s);
    System.out.println(map1);
  }

  // map 转 xml字符串
  public static String map2Xml(Map<String, Object> map) {

    // map转为json字符串
    String jsonStr = JSONUtil.toJsonStr(map);

    // json字符串转为json
    JSON json = JSONUtil.parse(jsonStr);

    // JSON转换为XML字符串
    String strXml = JSONUtil.toXmlStr(json);

    return strXml;
  }

  // xml字符串转map (用到了fastJson的JSONObject)
  private static Map<String, Object> xml2Map(String strXml) {

    // XML字符串转换为JSON
    JSONObject json = JSONUtil.parseFromXml(strXml);

    // json 转 json字符串
    String strJson = json.toString();

    Map<String, Object> map = com.alibaba.fastjson.JSONObject.parseObject(strJson, Map.class);

    return map;
  }
}

```
