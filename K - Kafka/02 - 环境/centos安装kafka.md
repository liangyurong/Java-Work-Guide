## centos安装kafka

下载

    https://archive.apache.org/dist/kafka/2.5.1/kafka_2.12-2.5.1.tgz

解压

    tar  -zxvf kafka_2.12-2.5.1.tgz

重命名

    mv kafka_2.12-2.5.1 kafka

启动(在kafka文件夹运行命令)（启动之前需要先启动zookeeper）

    // 启动zookeeper和kafka，并没有在两者之间设置什么，但是kafka就是启动成功了

    bin/kafka-server-start.sh config/server.properties

    














