
### Eureka两个组件

Eureka Server

Eureka Client

### Eureka Server 服务端

各个节点启动后，会在EurekaServer中注册，这样EurekaServer中的服务注册列表将会存储所有可用服务节点的信息。

服务节点可以在界面中直观得看到。

### Eureka Client 客户端

Eureka Client是一个java客户端，用于简化和Eureka Server的交互。

Eureka Client内置一个使用轮询负载均衡器，在应用启动后，将会向Eureka Server发送心跳（默认周期30s），

    定时任务

如果Eureka Server在多个心跳周期内没有接收到某个节点的心跳，Eureka Server将会从服务注册列表把这个服务节点移除（默认周期为90s）。

### 服务端和客户端

服务端是eureka本身

客户端就是服务提供者和消费者















