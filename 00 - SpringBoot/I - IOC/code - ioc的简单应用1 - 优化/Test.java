package com.demo.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {

        // 加载多个配置类(通过包名的方法去加载) - 推荐
        ApplicationContext context = new AnnotationConfigApplicationContext("com.demo.ioc");
        
        // 方法2：通过类型获取Bean
        DataConfig dataConfigBean2 = context.getBean(DataConfig.class);
        System.out.println(dataConfigBean2); // DataConfig(url=localhost:3306/lyr, driverName=Driver, username=root, password=123456)


    }
}
