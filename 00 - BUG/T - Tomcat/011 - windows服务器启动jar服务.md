## windows服务器启动jar服务出错

### 背景

使用Winsw将jar包做成windows服务，在本地可以启动服务，但是在梅州服务器启动失败

### 项目的报错日志（这个是本质原因）

```text
Error: Registry key 'Software\javaSoft\Java runtime Environment'\CurrentVersion' has value '1.8' , but '1.7' is required

Error: could not find  java.dll

Error: could not find java SE Runtime Environment
```

### 启动服务的报错信息（这个是表层原因）

```text
windows无法启动 xxx服务（位于本计算机上）

错误1067：进程意外终止
```

### 可能原因1

在xml文件中发现log文件路径设置的不对。我设置的是D盘，但是服务器只有C盘

```xml
<service>
   <logpath>D:logs\log</logpath>
</service>
```

解决：删除服务，重新设置xml的log文件路径，然后再生成服务

### 可能的原因2

是不是nginx打开了非常多？？？用taskmgr看一下

解决：结束多余到的nginx服务













