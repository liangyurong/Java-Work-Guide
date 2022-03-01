## 将json数据转为一个实体类

实体类
```jshelllanguage
public class User{
  private int id;
  private String name;    
}
```

转换
```jshelllanguage
public static void main(String[] args){
    String userString = "{"id":1,"name","lz"}";
    JSONObject userJson = JSONObject.parseObject(userString);
    User user = JSON.toJavaObject(userJson,User.class);
}
```














