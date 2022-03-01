## 打包会把其他的模块打包进来api的jar包

右侧maven project - 选择右边有(root)的那个 - 先clean再install

就会将整个项目打包成api.jar包。其他模块都会打包成jar包放到api.jar里面。你解压api.jar，就会看到boot-inf文件夹里面有个lib包，就可以找到其他模块的jar包

## api模块的pom.xml文件

api是主模块

这里就是把其他模块的东西给打包到api.jar
```xml
        <dependency>
            <groupId>com.sdyb</groupId>
            <artifactId>common</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>com.sdyb</groupId>
            <artifactId>dynamic-datasource</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
```


## commonm模块的pom.xml

声明了父类，然后写了自己的groupId和artifactId

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>com.sdyb</groupId>
        <artifactId>yb</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>
    <groupId>com.sdyb</groupId>
    <artifactId>common</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>common</name>
    <description>常用功能模块</description>
    <properties>
        <java.version>1.8</java.version>
    </properties>

</project>
```

## dynamic-datasource模块的pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>com.sdyb</groupId>
        <artifactId>yb</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>
    <groupId>com.sdyb</groupId>
    <artifactId>dynamic-datasource</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>dynamic-datasource</name>
    <description>数据库管理模块</description>
    <properties>
        <java.version>1.8</java.version>
    </properties>

</project>
```
