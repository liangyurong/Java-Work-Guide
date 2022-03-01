## 将jar包配置为windows服务


## 一、为什么要这么做？

在windows的服务器中，通过打开一个cmd窗口，执行java --jar xxxx.jar的方式，每一个cmd窗口，相当于一个临时session会话，当cmd窗口关闭之后，启动的java程序就停止了。
 
为了避免这种情况的发生，需要将执行jar包，以后台进程的方式执行jar包，类似linux服务器，以nohup java -jar xxx.jar的方式。

## 二、使用WinSW将jar包做成windows服务

### 2.1 实现步骤

1、下载WinSW 64位：https://github.com/winsw/winsw/releases

2、将下载的WinSW.NET4.exe文件复制到jar程序所在文件夹中（我的jar包是research.jar）

3、将WinSW.NET4.exe重命名为research.exe(和jar同名)

4、在同目录下新建一个xml文件，命名为research.xml，写入以下内容

```xml
<service>
     <id>research</id>
     <name>research</name>
     <description>research</description>
     <env name="JAVA_HOME" value="%JAVA_HOME%"/>
     <executable>java</executable>
     <arguments>-jar "C:\Users\lyr\Desktop\test\research.jar"</arguments>
     <startmode>Automatic</startmode>
     <logpath>D:logs\log</logpath>
     <logmode>rotate</logmode>
 </service>
```

5、xml补充说明

    id,name,description我都写成了和jar包相同的名称
    
    arguments：-jar后面写上自己jar包的路径
    
    logpath：log文件路径

6、运行：以管理员运行cmd进入jar所在的目录，然后执行research.exe install

```text
C:\Users\lyr\Desktop\test>research.exe install
Installing service 'research (research)'...
Service 'research (research)' was installed successfully.
```

7、出现上图的"Service 'research (research)' was installed successfully"，表示服务安装成功，然后去Windows服务里面启动服务（服务名称是research）

### 2.2 卸载已经安装的服务

以管理员运行cmd进入jar所在的目录，然后执行research.exe uninstall

### 2.3 评价

确实能运行项目，也能在自定义的log路径看到log执行日志

不方便的地方：每次修改一个地方的代码，都得停止服务，更新jar包，然后再启动服务。

### 2.4 可能遇到的问题

部署之后，服务启动不成功

解决方法一：对服务，右键选择属性，选择登录，勾选允许服务与桌面交互

解决方法二：使用全新的WinSW-x64.exe再设置一遍服务。

### 2.5 存在的问题 






## 三、一个比较傻的方法（不推荐）

下面的源码得放在bat文件（可以先写在txt文件，然后改为bat后缀）

评价：点击确实可以运行服务，但是在任务管理器看到的名称是java(TM)的，如果是运行多个项目，那么根本分不清楚是哪个项目，所以不推荐。

```txt
@echo off
start javaw -jar C:\Users\lyr\Desktop\test\research.jar
exit
```
