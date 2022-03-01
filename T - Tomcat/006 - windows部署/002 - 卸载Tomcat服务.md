## 一、卸载tomcat安装版

- 安装版tomcat，也就是类似tomcat.exe，可以直接在“控制面板”进行卸载。

## 二、卸载“解压版tomcat”

1、注意点：不能在“控制面板”删除“解压版tomcat”。

2、cmd窗口，输入命令进入到tomcat目录的bin文件夹
```txt
cd D:\lyr\mytomcat\tomcat_mybatisplus\bin
```
3、输入下面命令，删除tomcat服务。

说明：“服务”上的名称是：Apche Tomcat 8.5 tomcat_mybatisplus。但我命名的是tomcat_mybatisplus。一般来说，会在前面给你自动加上Apche+tomcat+版本号。

```txt
service.bat remove tomcat_mybatisplus
```
4、 关闭“服务”窗口，输入：win+r，然后输入services.msc，发现删除tomcat服务成功。
