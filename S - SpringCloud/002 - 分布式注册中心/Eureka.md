
读音：尤里卡

### Eureka是什么？

Eureka是Netflix开发的服务发现框架，

Eureka是一个基于REST的服务，用于定位，主要用于定位运行在AWS域中的中间层服务，以达到负载均衡和中间层服务故障转移的目的。

SpringCloud将它集成在其子项目spring-cloud-netflix中，以实现SpringCloud的服务发现功能。

服务注册与发现，对于微服务来说是非常重要的。有了服务与发现，只需要使用服务的标识符，就可以访问到服务，而不需要修改服务调用的配置文件。功能类似Dubbo的注册中心Zookeeper


### 



### 三大角色

Eureka Server ： 提供服务的注册与发现

Service Provider ： 将自身服务注册到Eureka中，从而使得消费方能够找到。

Service Consumer ： 服务消费方从Eureka中获取注册服务列表，从而找到消费服务。


























