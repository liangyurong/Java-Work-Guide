

安装docker

使用docker安装zookeper：准备Docker-compose.yml

```yml
version:"3.1"
services:
	zk:
		iamge:daocloud.io/daocloud/zookeeper:latest
		restart:always
		container_name:zk
		ports:
			- 2181:218
```



1、安装vmware

2、vm创建一个虚拟机，安装centos系统

3、虚拟机里面安装ZooKeeper

