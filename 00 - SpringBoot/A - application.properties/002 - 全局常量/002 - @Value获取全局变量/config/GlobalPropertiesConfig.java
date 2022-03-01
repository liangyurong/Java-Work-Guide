package com.sdyb.mp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

/**
 * 全局常量
 */
@Configuration
@Data
public class GlobalPropertiesConfig {

   @Value("${stu.name}")
   private String name;

   @Value("${stu.age}")
   private Integer age;

}
