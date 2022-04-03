### 设置 后端启动，即使关闭窗口，redis也不会断开（只需要设置一次）

1、编辑redis.conf

    cd redis
    
    vim redis.conf

2、找到daemonize no将其改为yes（在vim中插入数据按键盘上的i或者insert）

3、按esc退出insert模式，再按：，并且输入wq。代表保存并且退出

    ./redis.conf
    
### 启动redis  (注意: redis.conf文件不在同一层级)

    来到/redis/src目录，执行 ./redis-server  /redis/redis.conf

### 连接redis

    ./redis-cli










    