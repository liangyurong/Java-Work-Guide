
## windows服务器，tomcat启动war包报错

错误：java.util.zip.ZipException: error in opening zip file

### 尝试1:在本地项目选中pom.xml，右键选择reimport

没用

### 尝试2：可能是服务器的tomcat没权限？

没有尝试

### 解决

1、在本地项目的Lifecycle，先clean再install

2、重新打包成war再部署

注意：不能直接install

