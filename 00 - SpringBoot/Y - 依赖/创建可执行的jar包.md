

## 创建可执行的jar包

### 1、前提

我们需要导入父类依赖

```xml
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.4.RELEASE</version>
    </parent>
```

### 2、需要的依赖，其实本质上就是一个插件

```xml
<bulild>
   <plugins>
        <plugin>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
   </plugins>
</bulild>

```
### 3、操作

- 导入上面的插件依赖。
- 执行mvn package。（在IDEA的右上角）
- 运行完mvn package后，我们会在 target 目录下看到两个 jar 文件。myproject-0.0.1-SNAPSHOT.jar 和 myproject-0.0.1-SNAPSHOT.jar.original。
  - 第一个 jar 文件就是我们应用的可执行 jar 包。
  - 第二个 Jar 文件是应用原始的 jar 包。
