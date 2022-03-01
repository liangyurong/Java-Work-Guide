### JSONArray字符串转为JSONArray

```jshelllanguage
    String str = "[{ 'name':'xxx','age':12 }]";
    JSONArray jsonArray = JSONArray.parseArray(str);
```

### 如果str不是标准的json字符串

报错：Exception in thread "main" com.alibaba.fastjson.JSONException

解决：只能try catch吗？


