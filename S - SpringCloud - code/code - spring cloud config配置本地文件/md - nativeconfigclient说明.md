## nativeconfigclient说明

启动类

    基本springboot启动类

依赖

```xml
        <!-- config依赖 -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
        </dependency>
        <!-- 添加对bootstrap的支持 -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-bootstrap</artifactId>
            <version>3.1.3</version>
        </dependency>

        <!--  eureka服务端 : 自动注册到eureka中 ， 但是为什么会自动注册呢？-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
            <version>2.2.9.RELEASE</version>
        </dependency>
```

存在问题：该服务会自动注册到自动注册到eureka中

    为什么配置中心不需要注册到eureka？

    如果有多个eureka呢？

    为什么添加了spring-cloud-starter-netflix-eureka-server就能自动注册？能不能引入eureka-client来代替?

    没有编写：eureka.client.service-url.defaultZone

    解决：



