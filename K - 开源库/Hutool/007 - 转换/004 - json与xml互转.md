### 源码

```java
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

/**
 * 使用的JSONObject是hutool的
 */
public class TestJSon2Xml {

  public static void main(String[] args) {

    JSONObject json = JSONUtil.createObj();
    
    json.set("name", "yurong333");
    json.set("age", 25);

    // JSON转换为XML
    String strXml = JSONUtil.toXmlStr(json);

    // XML字符串转换为JSON
    JSONObject strJson = JSONUtil.parseFromXml(strXml);

  }
}

```

### 转换前的json

    {
        "person":
            {   "name":"yurong333",
                "age":25
            }
    }

### 转换后的xml

    <person>
        <name>yurong333</name>
        <age>25</age>
    </person>
