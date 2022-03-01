package com.lyr.demo;

import com.lyr.demo.util.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 必须有  SpringUtil.getInstance().setContext(context);，否则会报错：ApplicationContext未初始化
 */
@SpringBootApplication
public class RunApp {
    public static void main(String[] args) {
        ApplicationContext context  = SpringApplication.run(RunApp.class, args);
        SpringUtil.getInstance().setContext(context);
    }
}
