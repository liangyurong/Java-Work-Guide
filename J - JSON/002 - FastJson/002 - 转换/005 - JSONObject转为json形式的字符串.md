## JSONObject转为json形式的字符串

### 源码

```jshelllanguage
    JSONObject json = new JSONObject();
    json.put("name","yurong333");
    json.put("age","25");
    String result = JSONObject.toJSONString(json);
    System.out.println(result);
```

### 结果

{"name":"yurong333","age":"25"}

