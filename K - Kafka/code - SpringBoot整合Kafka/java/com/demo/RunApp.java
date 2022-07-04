package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) // 排除数据库
public class RunApp {
    public static void main(String[] args) {
        try {
            SpringApplication.run(RunApp.class,args);
        } catch (Throwable throwable) {
            System.out.println("异常信息===================================");
            throwable.printStackTrace();
        }
    }
}
