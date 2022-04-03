### bug

No instances available for xxx服务名

### 原因


### 解决

消费端的fetch-registry应该是true

```yml
eureka:
    client:
        register-with-eureka: false # 不向eureka中注册自己
        fetch-registry: true # false表示自己是一个注册中心,TRUE表示自己不是注册中心
```