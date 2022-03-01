### 1. tomcat下载链接

- 下载tomcat请点击：[链接](https://tomcat.apache.org/download-80.cgi)

- 如果云服务器环境是windows，那么选择windows版本。

![](https://img2020.cnblogs.com/blog/1043814/202104/1043814-20210412212918414-978444342.png)

### 2. 新建文件夹

- 新建文件夹，命名为tomcat_mybatisplus，将下载的文件解压到里面。

### 3.配置环境变量

- 配置路径：计算机→属性→高级系统设置→高级→环境变量

- 在系统变量，新建tomcat_mybatisplus变量，变量值为tomcat的解压路径：D:\lyr\mytomcat\tomcat_mybatisplus  （如果已存在该变量则新建其他命名的变量）（建议每次命名都是tomcat+项目名称，这样子启动的时候容易分辨）

- 在系统变量，新建CATALINA_BASE_tomcat_mybatisplus变量，变量值为：D:\lyr\mytomcat\tomcat_mybatisplus （变量命名规则：CATALINA_BASE_项目名称）

- 在系统变量，新建CATALINA_HOME_tomcat_mybatisplus变量，变量值为tomcat的解压路径：D:\lyr\mytomcat\tomcat_mybatisplus （变量命名规则：CATALINA_HOME_项目名称）

- 修改Path变量，点击编辑，分别在后面追加下面代码。

说明：分别对应上面的3个变量名称。

```java

%tomcat_mybatisplus%\bin

%CATALINA_BASE_tomcat_mybatisplus%\lib

%CATALINA_HOME_tomcat_mybatisplus%\bin

```
### 4. tomcat文件修改

- bin目录下打开catalina.bat

```java
CATALINA_BASE  全部换为->    CATALINA_BASE_tomcat_mybatisplus

CATALINA_HOME  全部换为->    CATALINA_HOME_tomcat_mybatisplus
```
- 在解压的tomcat的bin文件下找到startup.bat，在文件头添加以下两行代码。在解压的tomcat的bin文件下找到shutdown.bat，在文件头添加以下两行代码。（分别是java的jdk路径和解压的tomcat目录）

```java
SET JAVA_HOME=C:\Program Files\Java\jdk1.8.0_131
SET TOMCAT_HOME=D:\lyr\apache-tomcat-8.5.61
```

参考位置
![](https://img2020.cnblogs.com/blog/1043814/202104/1043814-20210412212605147-1558659967.png)

- 在tomcat的bin文件夹，打开service.bat ，添加以下代码。

说明：需要对应本地的jdk路径。

```java
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_131
```
参考位置

![](https://img2020.cnblogs.com/blog/1043814/202104/1043814-20210412212005425-1801379394.png)

- 在service.bat里面找到下面代码，将Tomcat8修改为tomcat_mybatisplus

```java
set DEFAULT_SERVICE_NAME=tomcat_mybatisplus
```

- 在bin的文件夹将tomcat8.exe重新命名tomcat_mybatisplus.exe

- 在service.bat里面将CATALINA_HOME全部替换为CATALINA_HOME_tomcat_mybatisplus

- 在service.bat里面将CATALINA_BASE全部替换为CATALINA_BASE_tomcat_mybatisplus

- 上述做完，直接在cmd窗口去到tomcat的bin目录下，输入service.bat install，即可弄成自启动服务。

- cmd窗口输入 services.msc即可看到服务。一般是Apache开头。

![](https://img2020.cnblogs.com/blog/1043814/202104/1043814-20210412212228480-636512739.png)

### 5. 端口的修改

- 原因：如果存在多个tomcat，则可能会造成端口冲突。

- 下面的8005一般会和已有的端口冲突，需要将8005端口为其他端口，比如8006。（tomcat目录的conf文件夹的server.xml修改））

![](https://img2020.cnblogs.com/blog/1043814/202104/1043814-20210412212321172-556869032.png)

- 访问端口默认为8080，一般也要更改为其他端口。（tomcat目录的conf文件夹的server.xml修改）

![](https://img2020.cnblogs.com/blog/1043814/202104/1043814-20210412212339959-1259407899.png)

### 6. 访问路径去掉项目名。比如这里的项目名是testdemo

- 以前的访问路径：localhost:8091/testdemo/hi

- 设置之后的访问路径：localhost:8091/hi

- **操作**：打开tomcat目录下的conf文件夹，找到server.xml。将里面的appBase设置为空，并添加下边那一行代码，其中docBase设置为项目的部署目录路径。

```java
<Host name="localhost"  appBase="" unpackWARs="true" autoDeploy="true">
<!--下面一行代码需要自己手动添加-->
<Context path="" docBase="D:\lyr\mytomcat\tomcat_mybatisplus\webapps\testdemo" debug="0" reloadable="true" crossContext="true"/>
```
