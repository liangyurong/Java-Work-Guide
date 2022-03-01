## JSONArray中取出JSONObject

获取JSONObject对象用JSONObject jsonobject.getJSONObject("key")方法

```jshelllanguage
         JSONArray array = json.getJSONArray("data");
         int size = array.size();
         for (int i = 0; i < size; i++) {
             JSONObject jsondata = array.getJSONObject(i);
         }
```
