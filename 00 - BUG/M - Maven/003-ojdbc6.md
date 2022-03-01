### 错误信息

打包jar的时候出错

 The POM for com.oracle:ojdbc6:jar:11.2.0.3 is missing, no dependency information available
 
### 补充

pom.xml已经有依赖，但是还是报错
```text
<dependency>
	<groupId>com.oracle</groupId>
	<artifactId>ojdbc6</artifactId>
</dependency>
``` 
 
### 原因

maven repositary 中没有这个资源，只能通过配置本地库才能加载到项目中去。

### 解决

添加最新的依赖
```txt
<dependency>
    <groupId>com.oracle.database.jdbc</groupId>
    <artifactId>ojdbc8</artifactId>
    <version>19.7.0.0</version>
</dependency>
```



 





