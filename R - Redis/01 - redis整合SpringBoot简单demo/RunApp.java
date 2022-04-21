package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunApp {
    public static void main(String[] args) {
        try {
            SpringApplication.run(RunApp.class,args);
        } catch (Throwable throwable) {
            System.out.println("异常信息】】】】】】】】】】】】】】】】】】】】】");
            System.out.println(throwable.toString());
            throwable.printStackTrace();
        }
    }
}
