

## 本地maven仓库配置ojdbc的jar包


### 错误信息

The goal you specified requires a project to execute but there is no POM in this directory (C:\Users\lyr). 

Please verify you invoked Maven from the correct directory. -> [Help 1]


解决：相关参数加上双引号  (补充：jar包路径要改为自己的)
```text
mvn install:install-file "-DgroupId=com.oracle" "-DartifactId=ojdbc8" "-Dversion=11.2.0.4 -Dpackaging=jar" "-Dfile=C:\Users\lyr\Desktop\aa\ojdbc8.jar"
```
