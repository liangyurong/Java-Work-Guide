## 快速命令

nohup java -jar xxx.jar &

ps -ef|grep xxx.jar

kill -9 进程号

## 一、启动jar：java -jar xxx.jar

打开xshell，进入到jar包所在路径，输入命令：java -jar xxx.jar

特点：当前ssh窗口被锁定，可按CTRL + C打断程序运行，或直接关闭窗口，程序退出

## 二、启动jar，关闭窗口不会终止jar包：nohup java -jar xxx.jar &

nohup java -jar xxx.jar &

## 三、使用nohup之后关闭jar包

### 1、查看jar包运行进程

ps -ef|grep xxx.jar

#### 1.1 查询到的信息

```text
root     1480231 1480121  1 09:12 pts/0    00:01:35 java -jar gyf2.jar
root     1496317 1483483  0 11:06 pts/2    00:00:00 grep --color=auto gyf2.jar
```

#### 1.2 信息解析

     --- 运行进程号 ---      
root     1480231     1480121  1 09:12 pts/0    00:01:35 java -jar gyf2.jar

#### 1.3 grep --color=auto gyf2.jar

意思：给gyf2.jar自动加上颜色

不用管这个的进程号，没关闭也没有什么影响

### 2、结束进程

命令：kill -9 进程号

结束进程：kill -9 1480231




















