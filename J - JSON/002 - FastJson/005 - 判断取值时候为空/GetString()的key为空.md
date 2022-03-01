

### 使用if(null == json.getString("ab))

```jshelllanguage
  public static void main(String[] args) {
    JSONObject json = new JSONObject();
    json.put("ab","");

    System.out.println(json.getString("ab")); // 输出空字符串
    System.out.println(json.getString("a2b") == null); // true
    System.out.println(json.getString("a2b").equals("null")); // 报错
  }
```
