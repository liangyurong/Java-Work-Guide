

## 说明

数据库是MySQL+SQL Server。

主要是使用了MyBatis-Plus的插件。依赖在pom.xml文件中。该插件可以独立使用。

## 星火

使用MP进行多数据源的切换，会不会有什么不安全或者不好的地方？这个暂时还不知道。2021-05-19

## 关键实现

主要的实现在impl层的 @DS("db2")  @DS("db1")注解


## 配置文件也和以前的配置不同

```properties
server.port=8081

# 在代码中使用 @DS 切换数据源。
# @DS 可以注解在方法上和类上。如果同时存在，方法注解优先于类上注解。强烈建议注解在 service 实现或 mapper 接口方法上。

spring.datasource.dynamic.primary=db1

# MySQL
spring.datasource.dynamic.datasource.db1.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.dynamic.datasource.db1.username=root
spring.datasource.dynamic.datasource.db1.password=123456
spring.datasource.dynamic.datasource.db1.url=jdbc:mysql://localhost:3306/lyr?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&serverTimezone=GMT%2B8

# SQL Server
spring.datasource.dynamic.datasource.db2.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.datasource.dynamic.datasource.db2.url=jdbc:sqlserver://127.0.0.1:1433;databaseName=lyr
spring.datasource.dynamic.datasource.db2.username=admin
spring.datasource.dynamic.datasource.db2.password=123456
```
