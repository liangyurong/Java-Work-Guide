### 步骤

1、打开xshell

2、cd ..

3、chmod 777 ./runredis.sh  

    直接运行./runredis.sh，会提示权限不够

### runredis.sh文件

    #!/bin/bash
    cd ..
    cd redis/src
    ./redis-server  /redis/redis.conf
    ./redis-cli