## centos安装zookeeper

首先需要安装jDK - 教程《CentOS安装JDK（yum安装）无需配置环境变量》

下载

    wget https://archive.apache.org/dist/zookeeper/zookeeper-3.6.0/apache-zookeeper-3.6.0-bin.tar.gz

验证

    sha512sum apache-zookeeper-3.6.0-bin.tar.gz

解压并进入文件夹

    tar zxvf  apache-zookeeper-3.6.0-bin.tar.gz && cd apache-zookeeper-3.6.0-bin

重命名文件夹为zookeeper

    mv apache-zookeeper-3.6.0-bin zookeeper

配置

    cp conf/zoo_sample.cfg  conf/zoo.cfg

vi conf/zoo.cf

    dataDir=/tmp/zookeeper
    dataDir=/var/lib/zookeeper

启动

    ./bin/zkServer.sh start

关闭

    ./bin/zkServer.sh stop