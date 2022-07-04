说明

    该kafka是centos直接安装的，并不是docker安装的

启动(在kafka文件夹运行命令)（启动之前需要先启动zookeeper）

    // 启动zookeeper和kafka，并没有在两者之间设置什么，但是kafka就是启动成功了
    cd kafka
    bin/kafka-server-start.sh config/server.properties