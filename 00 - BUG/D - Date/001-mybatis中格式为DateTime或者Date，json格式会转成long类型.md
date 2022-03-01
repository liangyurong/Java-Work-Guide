## mybatis中格式为DateTime或者Date，json格式会转成long类型的解决方案


只需在实体类的日期字段的getter方法上加上以下注解：
```text
@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")即可
```

例如：
```java
@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
public Date getGmtCreate() {
    return gmtCreate;
}
```
