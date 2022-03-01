
## 配置信息

```properties
spring.datasource.driver-class-name= com.mysql.cj.jdbc.Driver
spring.datasource.username= root
spring.datasource.password=123456
spring.datasource.url=jdbc:mysql://localhost:3306/lyr?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&serverTimezone=GMT%2B8
```

## 依赖

```xml
        <!--数据库驱动-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
```
