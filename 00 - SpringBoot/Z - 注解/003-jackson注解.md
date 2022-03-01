

```java
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;
```

### @JsonIgnoreProperties

作用一：放在实体类上，防止转换json数据的时候出现无限制循环
```java
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"}) 
public class XXXEntity{
    
}
```

作用二：作用在类上，用于过滤掉特定字段不返回或者不解析
```java
// 生成json时将userRoles属性过滤
@JsonIgnoreProperties(value = {"userRoles"}) 
public class User{
    private String id;
    private String name;
    
    @JsonIgnore
    private List<UserRole> userRoles = new ArrayList<>();
}
```

### @JsonFormat

设置日期格式
```java
@DateTimeFormat(pattern="yyyy-MM-dd") // 是否可以删除？
@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
private Date createTime=new Date();
```

### @JsonBackReference

原因：Jackson在序列化对象的时候，如果对象里面有循环依赖的情况，会报栈溢出

解决：加了@JsonBackReference注解的字段，不会被jackson序列化，也就打断了循环依赖。
```java
@JsonBackReference
private List<Question> questions=new LinkedList<>();
```


























