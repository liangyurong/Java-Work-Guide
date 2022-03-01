## 从JSONObject取出int，double，boolean

### 数据

```json
{
    "intVal": 1,
    "doubleVal": 0.618,
    "booleanVal": true
}
```

### 取出code对应的数据


```jshelllanguage
  public static void main(String[] args) {
    String jsonStr =
        "{\n"
            + "    \"intVal\": 1,\n"
            + "    \"doubleVal\": 0.618,\n"
            + "    \"booleanVal\": true\n"
            + "}";
    
    // 将String转为JSONObject
    JSONObject json = JSONObject.parseObject(jsonStr);

    Integer intVal = json.getInteger("intVal");
    Double doubleVal = json.getDouble("doubleVal");
    Boolean booleanVal = json.getBoolean("booleanVal");

    System.out.println(intVal);
    System.out.println(doubleVal);
    System.out.println(booleanVal);
  }
```


