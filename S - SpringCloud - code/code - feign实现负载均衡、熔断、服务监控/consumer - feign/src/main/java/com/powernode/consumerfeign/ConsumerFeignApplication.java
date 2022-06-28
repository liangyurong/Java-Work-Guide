package com.powernode.consumerfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients // 开启feign客户端，才能帮助我们调用interface的接口
@EnableCircuitBreaker // 开启熔断机制（开启服务监控也需要用到该注解）
@EnableHystrixDashboard // 开启服务监控
public class ConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignApplication.class, args);
        System.out.println("负载均衡："+"http://localhost:8083/feign/hello");
        System.out.println("数据监控可视化界面："+"http://localhost:8083/hystrix"); // 在里面添加http://localhost:8083/actuator/hystrix.stream，可以看到可视化界面
        System.out.println("数据监控："+"http://localhost:8083/actuator/hystrix.stream");

    }


}
