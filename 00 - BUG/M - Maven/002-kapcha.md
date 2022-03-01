
### bug信息

 'dependencies.dependency.version' for com.google.code:kaptcha:jar is missing
 
### 背景

想要打包成jar包，然后出现这个错误 
 
###  已经失效（2021-08-30）
```text
<!--<dependency>-->
	<!--<groupId>com.google.code</groupId>-->
	<!--<artifactId>kaptcha</artifactId>-->
<!--</dependency>-->
```

### 现在采用这个依赖就可以成功
```text
<dependency>
	<groupId>com.github.penggle</groupId>
	<artifactId>kaptcha</artifactId>
	<version>2.3.2</version>
</dependency>
```
