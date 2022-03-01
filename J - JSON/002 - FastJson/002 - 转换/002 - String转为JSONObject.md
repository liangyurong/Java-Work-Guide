

## 将String转为JSONObject

```jshelllanguage
   String userString = "{"id":1,"name","lz"}";
   JSONObject userJson = JSONObject.parseObject(userString);
   User user = JSON.toJavaObject(userJson,User.class);
```

















