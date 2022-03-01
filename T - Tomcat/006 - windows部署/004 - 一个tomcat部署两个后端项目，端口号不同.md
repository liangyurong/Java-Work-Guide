## 004-一个tomcat部署两个后端项目，端口号不同

csdn上有响应的教程，但是太麻烦

## 一个比较巧妙的方法

1、同一个tomcat部署两个项目（比如student和people项目）

2、使用nginx进行转发

### 步骤

1、安装好tomcat.exe

2、去到tomcat安装路径，打开webapps，删除所有的文件

3、关闭tomcat服务，放入student的war包，启动tomcat，生成student文件夹

4、关闭tomcat服务，放入people的war包，启动tomcat，生成people文件夹
