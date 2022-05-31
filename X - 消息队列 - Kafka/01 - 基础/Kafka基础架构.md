

### Broker

broker：消息中间件处理节点。

一个Kafka节点就是一个broker，多个broker可以组成一个kafka集群。

Broker里面有多个topic，topic有多个partition

### Topic 主题

Kafka根据topic对消息进行归类，发布到kafka集群的每条消息都要指定一个topic

### Partition

物理上的概念。

一个topic可以分为多个partition，每个partition内部消息是有序的

partition可以提高topic的负载均衡

### Producer

消息生产者，向Broker发送消息的客户端

### Consumer

消息消费者，从Broker读取消息的客户端

### ConsumerGroup

每个Consumer属于一个特定的Consumer Group

一个消息可以被多个不同的Consumer Group消费，但是一个Consumer Group里面只能有一个Consumer能消费该消息



