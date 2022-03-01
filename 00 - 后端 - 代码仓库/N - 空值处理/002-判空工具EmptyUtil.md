
依赖
```text
  <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.60</version>
  </dependency>
```

### 判空工具的全部方法

```java
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class EmptyUtil {

   public static boolean isEmpty(String str){
       return null == str || "".equals(str);
   }

   public static boolean isEmpty(JSONObject json){
      return null == json  || 0 == json.size();
   }

   public static boolean isEmpty(JSONArray jsonArray){
      return null == jsonArray || 0 == jsonArray.size();
   }

   public static boolean isEmpty(Object obj){
      return null == obj ;
   }

}
```
