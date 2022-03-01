## 分离jar中的lib包

1、springboot项目什么都不用动，直接通过maven工具package打包，进行解压。并把\BOOT-INF\lib目录下的lib文件夹整个内容复制出来。（取出lib文件夹的内容）

2、在项目pom.xml中的plugin中加入以下内容，注意层级关系以及要把入口类改成对应的项目名。(start到end的内容)

3、再次打包，就没了lib包

### 参考

https://www.cnblogs.com/ooo0/p/14767608.html

### 添加的内容

groupId

artifactId

mainClass

```xml
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <!--start-->
    <configuration>
        <!--这里对应项目的主入口-->
        <mainClass>com.ityj.multidb.SpringbootMultiDatasourcesApplication</mainClass>
        <layout>ZIP</layout>
        <includes>
            <include>
                <groupId>nothing</groupId>
                <artifactId>nothing</artifactId>
            </include>
        </includes>
    </configuration>
    <executions>
        <execution>
            <goals>
                <goal>repackage</goal>
            </goals>
        </execution>
    </executions>
    <!--end-->
    
</plugin>
```





















