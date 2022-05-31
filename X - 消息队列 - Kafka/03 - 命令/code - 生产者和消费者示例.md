### 生产者和消费者示例

打开新的xshell对话，建立一个test的topic

    cd kafka

    ./bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test

在原会话窗口，打开一个producer

    ./bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test

    // 创建成功后，会出现>的命令行

新打开xshell窗口，打开一个consumer

    cd kafka

    ./bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning

随后生产者和消费者就能进行发送

    生产者发送一条String消息

    消费者就能接受并消费该消息









