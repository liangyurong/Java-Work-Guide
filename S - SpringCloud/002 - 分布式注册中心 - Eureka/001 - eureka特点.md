## 二、特点

### 2.1 服务的自动注册

微服务应用在启动时，通过注册中心客户端组件，将服务相关信息自动注册给注册中心服务端。

### 2.2 服务的健康检查

当已经注册到注册中心的微服务实例宕机后，注册中心服务端能够发现实例已经宕机，并把相关信息从注册中心删除掉。

### 2.3 服务的自动发现

服务消费者需要能实时监听到注册中心服务信息的变更，以便能在真正调用服务时不会出现错误。
