
### application.yml
```yml
spring:
  datasource:
    username: root
    password: 123456
    url: jdbc:mysql://192.168.1.3:3306/jpa?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT   #192.168.1.3 is my computer ip ,jpa is database name
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: update # create:每次都新建表 update:有表就不会新建
    show-sql: true #在控制台显示sql
    database-platform: org.hibernate.dialect.MySQL5Dialect #数据库引擎
    generate-ddl: true
```

### application.properties

```properties
spring.datasource.username=root
spring.datasource.password=123456
spring.datasource.url=jdbc:mysql://localhost:3306/questionnaire?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&serverTimezone=GMT%2B8
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
```
