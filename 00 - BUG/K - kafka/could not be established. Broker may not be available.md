bug

    could not be established. Broker may not be available

reason

    连接不上虚拟机的kafka

solve

    // 修改kafka的配置文件
    // 路径： /kafka/config/server.properties
    // 下面的代码是修改之后的
    listeners=PLAINTEXT://192.168.64.130:9092