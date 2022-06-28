package com.powernode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// 在该类点击启动按钮，启动完毕，访问：http://localhost:8761/ ，

@SpringBootApplication
@EnableEurekaServer // 开启eureka的注册中心的功能
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

}
