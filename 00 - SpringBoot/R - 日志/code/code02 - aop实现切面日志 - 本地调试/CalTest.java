package com.demo.aop_log;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalTest {
    // 直接运行此类，得到日志信息
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.demo.aop_log");
        Cal bean = context.getBean(Cal.class);
        bean.add(9,8);
        bean.sub(9,8);
        bean.mul(9,8);
        bean.div(9,8);

    }
}
