## nativeconfig说明

启动类注解

    需要声明配置中心

```java
@SpringBootApplication
@EnableConfigServer // 声明配置中心
public class NativeConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(NativeConfigApplication.class,args);
    }
}
```

依赖

    添加spring cloud config依赖

       <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-config-server</artifactId>
            <version>2.0.2.RELEASE</version>
        </dependency>
