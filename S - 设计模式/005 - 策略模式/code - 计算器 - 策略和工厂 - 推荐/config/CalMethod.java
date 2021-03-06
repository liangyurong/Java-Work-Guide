package com.demo.设计模式.策略模式.计算器_策略和工厂.config;

import java.lang.annotation.*;

/**
 * 自定义注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
public @interface CalMethod {
    /**
     * 描述
     * @return
     */
    String desc() default "";

    /**
     *  策略key
     * @return
     */
    String value() default "";
}
