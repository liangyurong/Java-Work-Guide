package com.demo.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {

        // 读取配置类来初始ioc容器（只能加载一个配置类） - 不推荐
        // ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        // 加载多个配置类(通过包名的方法去加载) - 推荐
        ApplicationContext context = new AnnotationConfigApplicationContext("com.demo.ioc");

        // 方法1：通过名字获取Bean
        // bean的默认值是方法名
        Object dataConfigBean1 = context.getBean("dataConfig");
        System.out.println(dataConfigBean1); // DataConfig(url=localhost:3306/lyr, driverName=Driver, username=root, password=123456)

        // 方法2：通过类型获取Bean
        DataConfig dataConfigBean2 = context.getBean(DataConfig.class);
        System.out.println(dataConfigBean2); // DataConfig(url=localhost:3306/lyr, driverName=Driver, username=root, password=123456)


    }
}
