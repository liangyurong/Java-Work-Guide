package com.lyr.writetosee.annotation;

import java.lang.annotation.*;

/**
 * @author lyr
 * @date 2021-10-19
 *
 * 加一个@interface，就能够单独使用
 */
@Target(ElementType.METHOD) // ElementType.METHOD表示可以用在方法上
@Retention(RetentionPolicy.RUNTIME) // 运行时保留。是什么意思呢？
@Documented
@Inherited
public @interface AutoLog {

    /**
     * 日志内容
     *
     * @return
     */
    String value() default "";

    /**
     * 日志类型
     *
     * @return 0:操作日志;1:登录日志;2:定时任务;
     */
    int logType() default 1;

    /**
     * 操作日志类型
     *
     * @return （1查询，2添加，3修改，4删除）
     */
    int operateType() default 0;
}
