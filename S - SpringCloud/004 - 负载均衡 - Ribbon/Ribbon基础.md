
### 什么是Ribbon

Spring Cloud Ribbon是一个基于http和tcp的客户端负载均衡工具，它基于Netflix Ribbon实现。

简单的说，Ribbon是Netflix发布的开源项目，主要功能是提供客户端的软件负载均衡计算，将NetFlix的中间层服务连接在一起。

通过spring cloud的封装，可以让我们轻松的将面向服务的rest模板请求自动转换成客户端负载均衡的服务调用。

Ribbon的客户端组件提供一系列完整的配置项如：连接超时、重试等等。

简单的说，就是在配置文件中列出LoadBalancer(简称LB:负载均衡)后面所有的机器，Ribbon会自动的帮助你甚于某种规则（如简单轮询，随机连接等等）去连接这些机器。我们也很容易使用Rbbo实现自定义的负裁均衡算法！




















