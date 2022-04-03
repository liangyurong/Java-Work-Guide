### bug

Request execution error. endpoint=DefaultEndpoint{ serviceUrl='http://localhost:8761/eureka/}

### 原因



### 解决

在application.yml添加以下语句

```yml
eureka:
    client:
        fetch-registry: false # false表示自己是一个注册中心
```








