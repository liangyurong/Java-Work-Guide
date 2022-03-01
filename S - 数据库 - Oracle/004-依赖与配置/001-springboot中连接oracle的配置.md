## springboot中连接oracle的配置

```properties
# 普通的连接oracle配置信息

spring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver
spring.datasource.url=jdbc:oracle:thin:@127.0.0.1:1521/orcl
spring.datasource.username=C##YB_MED_OPENEHR
spring.datasource.password=zteict2017

server.port=8079

# jpa配置
## 第一次加载hibernate时根据model（宫颈癌）类会自动建立表结构，后面服务程序重启时，加载hibernate会根据model（宫颈癌）类自动更新表结构，如果表结构改变了，但是表行仍然存在，不会删除以前的行（对于表结构行只增不减）
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
