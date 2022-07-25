## docker启动kafka镜像生成kafka容器

命令

    // 容器名：thekafka
    // 2181是zookeeper默认端口，9092是kafka默认端口
    docker run -d --name thekafka -p 9092:9092 -e KAFKA_BROKER_ID=0 -e KAFKA_ZOOKEEPER_CONNECT=192.168.64.130:2181/kafka -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://192.168.64.130:9092 -e KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092 -v /etc/localtime:/etc/localtime wurstmeister/kafka


-e KAFKA_BROKER_ID=0  
    
    在kafka集群中，每个kafka都有一个BROKER_ID来区分自己

-e KAFKA_ZOOKEEPER_CONNECT=192.168.64.130:2181/kafka

    配置zookeeper管理kafka的路径

-e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://192.168.64.130:9092

    把kafka的地址端口注册给zookeeper，如果是远程访问要改成外网IP,类如Java程序访问出现无法连接

-e KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092

    配置kafka的监听端口

-v /etc/localtime:/etc/localtime wurstmeister/kafka

    容器时间同步虚拟机的时间
