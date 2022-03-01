## windows无法启动tomcat服务

可能的原因：server.xml中有中文（解决：将中文改为英文）

### 解决办法1：将Tomcat服务删除，再重新添加Tomcat服务

意思：就是将安装的服务全部删除，然后再重新安装tomcat

步骤1：去到对应的tomcat路径，在路径上输入cmd

步骤2：打开cmd，输入： .\Uninstall.exe -ServiceName="tomcat服务名称"   （在服务，打开tomcat的属性可以看到名称）


### 删除了tomcat服务，但是在服务上还有tomcat

1、以管理员身份运行cmd

2、输入命令：sc delete tomcat服务名称 (cmd输入services.msc打开服务，在tomcat服务的属性可以看到名称)














