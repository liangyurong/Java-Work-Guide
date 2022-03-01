

### 一、@propertySource

- 加载指定的配置文件。读取内部指定的配置文件，而不是特定的application.properties。因为有时候需要读取特定的文件，因而将一些配置的值独立出来。

- @propertySource无法加载.yml文件，可以加载.properties文件。

#### 1. @propertySource使用示例

```java
@PropertySource(value={"classpath:person.properties"}) //特定的配置文件所在路径
@Component
@ConfigurationProperties(prefix="person") //该注解不可缺少，需要指明person的前缀
@Data
public class Person{
    private String name;
    private String password;
}
```

person.properties
```properties
person.name=yurong2333
person.password=123456
```

### 二、@ImportResource （还没有写具体，无法使得别人一看就知道这个注解是做什么的）

- 作用：导入Spring的配置文件，让配置文件里面的内容生效。