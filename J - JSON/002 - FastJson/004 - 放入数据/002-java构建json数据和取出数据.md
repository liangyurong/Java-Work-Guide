
## FastJson

JSONArray arr= new JSONArray();
arr.add(int index,Object object); //object一般是JSONObject数据

JSONObject obj = new JSONObject();
obj.put(String key,Object object)

使用这两个方法，就可以嵌套任何需要的数据。


### 整一个数据是JSONObject，包含了一个JSONArray数组。
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
### 从JSONObject中取出JSONArray数组

```text
JSONArray optionsArr = json.getJSONArray("options");
```

### 从JSONArray中取出某个位置的数据

```text
int size = optionsArr.size(); 
for(int i=0 ; i<size; i++){
   JSONObject jsonObject = optionsArr.getJSONObject(i); // 获取第i个的JSONObject
   String optionContent = jsonObject.getString("optionContent"); // 获取第i个的JSONObject的optionContent属性
}
```

### 构建一个数据放入optionsArr

```text
JSONObject json = new JSONObject();
json.put("optionContent","newContent");
optionsArr.add(size+1,json);
```



