
### 作用

- 给容器中导入组件

- 用来引入额外的一个或者多个 @Configuration 修饰的配置文件类。

- 在不想给每个配置类都加上@Configuration注解，可以在主要的注解类上添加@Import(其他配置类.class)

```java
@Configuration
@ComponentScan(value={"com"})
@Import(JdbcConfig.class)
public class SpringConfiguration{
    //...
}
```

```java
//此时JdbcConfig.class不能再添加@Configuration注解
public class JdbcConfig{
    //...
}

```