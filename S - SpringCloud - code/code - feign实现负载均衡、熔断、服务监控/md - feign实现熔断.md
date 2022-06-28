## feign实现熔断

启动类需要的注解

    @EnableEurekaClient
    @SpringBootApplication
    @EnableFeignClients // 开启feign客户端，才能帮助我们调用interface的接口

熔断接口

    value：写服务名，也就是provider模块的配置文件的spring.application.name

    fallback: 写降级处理的类型，当provider服务不可用，则会自动调用fallback的类

    方法的mapping路径，直接写provider服务的controller路径即可，格式是http的restful格式

```java
// 访问下面的接口，如果成功则直接访问，如果出现问题则跳转到FeignError.class
@FeignClient(value = "provider",fallback = FeignError.class) // value写的是服务名，fallback写的是降级处理的类名
@Primary
public interface FeignProviderClientInterface {

    @GetMapping("/hello")
    String hello();
}
```

依赖

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