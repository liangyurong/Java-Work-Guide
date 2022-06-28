## 服务监控

启动类需要的注解

    @EnableEurekaClient
    @SpringBootApplication
    @EnableCircuitBreaker // 开启熔断机制（开启服务监控也需要用到该注解）
    @EnableHystrixDashboard // 开启服务监控

application.yml

    开启熔断机制：这个是开启feign对熔断的支持

```yml
# 开启feign对熔断的支持(spring cloud 2.3.12)
feign:
  circuitbreaker:
    enabled: true

# 服务监控
management:
  endpoints:
    web:
      exposure:
        include: 'hystrix.stream'
# 服务监控。解决bug：Unable to connect to Command Metric Stream
hystrix:
  dashboard:
    proxy-stream-allow-list: "*"
```

依赖

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>

        <!-- Spring Cloud2020之后，需要引入 spring-cloud-starter-netflix-hystrix 依赖。 -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
        </dependency>

        <!-- 服务监控 -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
            <version>1.4.7.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>

    </dependencies>
