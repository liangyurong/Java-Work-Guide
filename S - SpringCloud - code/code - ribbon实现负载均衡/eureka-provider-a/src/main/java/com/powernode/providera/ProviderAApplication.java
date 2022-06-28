package com.powernode.providera;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableEurekaClient
public class ProviderAApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderAApplication.class, args);

    }

}
