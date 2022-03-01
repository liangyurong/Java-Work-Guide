## tortoisegit提交时忽略target目录

### 步骤

1、在git同级别目录，新建文件，命名为：.gitignore

2、打开.gitignore

3、添加下面忽略的文件

```text
.mymetadata
.checkstyle
.classpath
.project
.class
.war
.zip
.rar
.idea
target
*.iml
.settings/*
/indexes/*
/src/main/webapp/WEB-INF/classes/*
/src/main/webapp/userfiles/*
/target/
/src/main/resources/rebel.xml
/src/main/resources/jeesite.properties


