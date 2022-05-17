### 步骤

1、打开xshell

2、cd ..

3、./runredis.sh  

    提示权限不够：chmod 777 ./runredis.sh  

### runredis.sh文件

    #!/bin/bash
    cd ..
    cd redis/src
    ./redis-server  /redis/redis.conf
    ./redis-cli