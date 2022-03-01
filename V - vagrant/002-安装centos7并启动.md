## 步骤

1、打开cmd

2、输入：vagrant init centos/7 （只需要使用一次，以后都不需要再执行此命令）

3、启动：vagrant up

```text
需要下载容器，比较慢

需要打开virtualbox

创建完成之后会自动帮我们自动启动虚拟环境，可以在virtualbox左边看到一个

启动的时候会帮我们创建了ssh连接，默认用户名是vagrant

启动完成会出现这样的字符串：==> default: Rsyncing folder: /cygdrive/c/Users/lyr/ => /vagrant ， virtualbox左边的红色图标也显示“正在运行”

启动完成之后，输入：ctrl+c，退出

```

4、开启ssh连接：vagrant ssh
```text
默认使用账户vagrant连接上virtualbox

出现[vagrant@localhost ~]，说明连接成功

ssh连接成功，就可以使用linux的命令了



```

### 错误

```text
`Vagrantfile` already exists in this directory. Remove it before running `vagrant init`.
```

解决：其实已经安装好了，并不是一个错误，在C盘的用户文件夹出现Vagrantfile文件说明就ok了  















