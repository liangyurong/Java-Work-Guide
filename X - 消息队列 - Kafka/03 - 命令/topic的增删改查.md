## topic的增删改查


### 创建名为test的topic

    ./bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test

解释：replication-factor 1

    副本1个

解释：--partitions 1

    分区1个

### 查看所有topic

    ./bin/kafka-topics.sh --zookeeper localhost:2181 --list

### 删除名为test的topic

    ./bin/kafka-topics.sh --zookeeper localhost:2181 --delete --topic test