

### 目的

有些不想上传到github

### 安装插件

File -> Settings -> Plugins 搜索框搜索.ignore，点击安装，然后重启IDEA。

### 生成初始.ignore文件

-> new ->找到 .ignore file -> gitignore file( git ) -> 弹框，选择java，点击generate

然后末尾追加两行代码

```txt
.mymetadata
.checkstyle
.classpath
.project
.class
.war
.zip
.rar
.idea
*.iml
.settings/*
/indexes/*
/target/*
/src/main/webapp/WEB-INF/classes/*
/src/main/webapp/userfiles/*
/target/
/src/main/resources/rebel.xml
/src/main/resources/jeesite.properties
```
