
## git did not exit cleanly (exit code 128)

背景：在clone gitlab项目到本地，出现该错误 （push代码可能也出现该错误）

原因：本地的账户密码可能出现了错误

第一种方法
```text
首先尝试这种方法，如果clone几次，弹出输入账号密码，输入正确即可clone成功

如果一直失败。尝试解决方法2。
```

第二种方法

```txt

1、本地电脑 - 控制面板 - 右上角搜索框搜索”凭据管理器“ -  管理windows凭据 - 普通凭据

2、我登录的gitlab地址是：git:http://main.sdyunban.com:8888，直接删除即可

3、重新去git clone项目，输入账户密码，即可成功

```

第三种方法：找到Git/etc文件下hosts，在里面加上ip地址，比如：github.com

第四种：重新生成ssh key也没解决。

第五种：域名换为ip地址















