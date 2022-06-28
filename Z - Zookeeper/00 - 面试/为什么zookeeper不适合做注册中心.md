## 为什么zookeeper不适合做注册中心

zookeeper保证的是CP

在Zookeeper集群中，当发生网络故障导致master节点和slave节点失联时，剩余的slave节点会进行leader选举，而在选举的过程中，zookeeper集群不可用，不能对外提供注册和查询的服务。






















