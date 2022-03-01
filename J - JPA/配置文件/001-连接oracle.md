
### application.properties

```properties
## 端口
server.port=8079

# 普通的连接oracle配置信息
spring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver
spring.datasource.url=jdbc:oracle:thin:@127.0.0.1:1521/orcl
spring.datasource.username=C##YB_MED_OPENEHR
spring.datasource.password=zteict2017

# jpa配置
## 第一次加载hibernate时根据实体类类会自动建立表结构，后面服务程序重启时，加载hibernate会根据model（宫颈癌）类自动更新表结构，如果表结构改变了，但是表行仍然存在，不会删除以前的行（对于表结构行只增不减）
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

```

### oracle依赖

```xml
	<dependency>
			<groupId>com.oracle.database.jdbc</groupId>
			<artifactId>ojdbc8</artifactId>
			<version>19.7.0.0</version>
		</dependency>
```


### 淘汰的依赖-别再用了

```xml
<dependency>
	<groupId>com.oracle</groupId>
	<artifactId>ojdbc6</artifactId>
</dependency>
```
