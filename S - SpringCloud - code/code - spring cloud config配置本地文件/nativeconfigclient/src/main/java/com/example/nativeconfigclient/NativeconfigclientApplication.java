package com.example.nativeconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NativeconfigclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NativeconfigclientApplication.class, args);
        System.out.println("访问："+"http://localhost:8070/native");
    }

}
