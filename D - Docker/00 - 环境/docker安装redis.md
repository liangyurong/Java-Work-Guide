
### 以管理员打开powershell

docker run -d -p 6379:6379 --name redis redis:latest

### 命令解释

docker run ： docker运行一个软件

-d：后台运行

-p 6379:6379 ： 表示端口的暴露，将容器里面的6379端口暴露到宿主机中。 左边是宿主机端口，右边是容器端口。

--name redis：将此容器命名为redis

redis:latest : 使用redis的最新版本 （可以指定docker的版本）































