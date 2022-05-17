### 改进

使用docker来设置多个redis实例

### 说明

在一个虚拟机上，启动多个redis服务器

6379是主机

6380，6381是从机

## 步骤

### 新建myredis文件夹

将redis文件夹中的redis.conf复制到myredis文件夹

### 在myredis文件夹新建三个文件

redis6379.conf

    include /myredis/redis.conf   # 公共部分
    pidfile /var/run/redis_6379.pid 
    port 6379
    dbfilename dump6379.rdb

redis6380.conf

    include /myredis/redis.conf   # 公共部分
    pidfile /var/run/redis_6380.pid 
    port 6380
    dbfilename dump6380.rdb

redis6381.conf

    include /myredis/redis.conf   # 公共部分
    pidfile /var/run/redis_6381.pid 
    port 6381
    dbfilename dump6381.rdb

### 启动三台redis服务器

    cd ..

    cd redis/src   # 只能去redis的src文件夹中执行

    ./redis-server /myredis/redis6379.conf

    ./redis-server /myredis/redis6380.conf

    ./redis-server /myredis/redis6381.conf

启动之后，这三台redis都是主机，相互之间没有关系

### 查看redis启动结果

    ps -ef | grep redis

### 查看redis服务器的角色

打开新窗口

    cd redis/src

    ./redis-cli -p 6379

    info replication

打开新窗口

    cd redis/src

    ./redis-cli -p 6380

    info replication

打开新窗口

    cd redis/src

    ./redis-cli -p 6381

    info replication

分析：可以看到三个redis服务器的role都是master

    说明三个redis服务器之间没有关系

### 配置从库，不需要配置主库

设置某个redis服务器成为其他服务器的从机

    连接从机，输入命令：slaveof 主机ip 主机端口

比如6379是主机，其他是从机

    进入6380：slaveof 127.0.0.1 6379

    进入6381：slaveof 127.0.0.1 6379

### 取消主从关系

    进入从机，输入命令：salveof no one
