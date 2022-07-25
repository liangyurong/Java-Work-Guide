### docker安装redis

安装

    docker pull redis

创建文件

    mkdir -p  /mydata/redis/conf
    cd /mydata/redis/conf
    touch redis.conf

创建redis容器

    docker run -p 6379:6379 --name redis -v /mydata/redis/data:/data  -v /mydata/redis/conf/redis.conf:/etc/redis/redis.conf -d redis redis-server /etc/redis/redis.conf

查看运行中的镜像

    docker images

启动redis，进入命令行

    docker exec -it redis redis-cli

    退出：ctrl+c































