### 源码

```jshelllanguage
  public static void main(String[] args) {
    String url = "https://www.baidu.com";
    
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("city", "北京");

    String result = HttpUtil.get(url, paramMap);

    System.out.println(result);
  }
```

### 分析
