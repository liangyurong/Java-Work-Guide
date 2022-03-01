

### 一、给普通变量赋值

application.properties
```properties
lyr.name=yurong333
```
某个类
```java
class xxxUtil{
     @Value("${lyr.name}")
     @Setter
     @Getter
     private String name;
}
```
使用示例
```text
@AutoWired
private xxxUtil myutil;

String studentName = myutil.getName();
```

### 二、给静态变量赋值

说明：SpringBoot中，若是在静态变量声明之上直接添加@Value()注解是无效的，获取到的结果是null

application.properties
```properties
lyr.name=yurong333
```

某个类
1. 类要添加@Component
2. 属性添加注解@Getter
```java
@Component
class xxxUtil{
    @Getter
    private static String name;

    @Value("${lyr.username}")
    public void setName(String username){
        name=username;
    }   
}
```
使用示例 
```text
xxxUtil.name
```





















/
