### 依赖说明

Spring Cloud 2020之后，需要引入 spring-cloud-starter-netflix-hystrix 依赖。 单纯引入openfeign无法使用负载均衡

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
        </dependency>

所以总的依赖有：eureka-client , openfeign , hystrix , web

### 数据监控依赖

       <!-- 数据监控 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>