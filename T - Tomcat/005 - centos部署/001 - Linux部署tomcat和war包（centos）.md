
### 注意、如果同一个linux服务器部署了多个tomcat

除了监听客户端请求的端口不同(8080一般改为对应项目的端口即可)
```text
<Connector port="8080" protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8443" />
```

关闭tomcat的端口也应该不同。（第一个就默认8005，第二个可以是8505，第三个可以是8605.。。）
```text
<Server port="8505" shutdown="SHUTDOWN">
```

### 一、下载tomcat8.5.68

link：https://tomcat.apache.org/download-80.cgi

选择core下面的tar.gz(pgp,sha512)。

tomcat压缩包文件名称：apache-tomcat-8.5.68.tar.gz

### 二、安装tomcat

登录winSCP，将压缩包放到文件夹：/usr/local/tomcat

从XSHELL中登录，进入文件夹：cd /usr/local/tomcat

解压：tar zxvf apache-tomcat-8.5.68.tar.gz

删除压缩包：rm -f apache-tomcat-8.5.68.tar.gz

重命名文件夹apache-tomcat-8.5.68为tomcat_wechatorderpay_8078：mv  apache-tomcat-8.5.68  tomcat_wechatorderpay_8078

### 三、部署war包

```text
cd tomcat_wechatorderpay_8078

cd webapps

进入WebApp文件夹，删除掉除ROOT文件夹外的所有文件夹
rm -rf docs
rm -rf examples
rm -rf host-manager
rm -rf manager

将war包放进webapps文件夹
```

### 四、Tomcat的启动与关闭，部署war包（使用Xshell软件的命令行）

首先需要进入到bin文件夹

启动tomcat：./startup.sh

关闭tomcat：./shutdown.sh

使用./startup.sh启动tomcat之后，再使用./shutdown.sh关闭tomcat
1. 去到webapps文件夹。
2. 删除ROOT文件夹里的所有文件。
3. 下面会生成一个tomcat_wechatorderpay_8078文件夹，将tomcat_wechatorderpay_8078文件夹里的全部文件移动到webapps文件夹下的ROOT文件夹。

### 虽然tomcat_wechatorderpay_8078里的工程访问端口是8078，但是浏览器那边的访问端口还是8080

比如访问：http://134.175.207.83:8080/hi，成功

比如访问：http://134.175.207.83:8078/hi，失败

因此需要更改tomcat的访问端口
- 进入conf目录，修改server.xml，输入命令：vi server.xml
- 进入之后，输入i，可以编辑。
- 编辑完，按Esc退出编辑
- 编辑完，保存并推出    :wq
- 编辑完，不保存就推出  :q!

修改的端口在这，将8080改为你的端口
```text
<Connector port="8080" protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8443" />
```

### 五、Tomcat的启动与关闭，部署war包（使用WinSCP软件的GUI界面进行操作）

可以不使用命令行，直接界面进行操作。

直接点击startup.sh和shutdown.sh

## 注意

工程部署到tomcat之后，properties中设置的前缀就失效了，没用了。访问路径就不用加上这些前缀。







