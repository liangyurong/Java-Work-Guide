
### 查看

打开cmd，输入命令：netstat -aon|findstr "8081"

### 杀死进程

杀掉占用端口的进程（比如占用8081端口的是2000）

taskkill /f  /pid 2000      //强制关闭某个进程
