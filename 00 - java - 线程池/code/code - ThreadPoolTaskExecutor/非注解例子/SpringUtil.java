package com.lyr.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 有什么用？反射？
 *
 * 联系上下文，算不算是使用单例模式创建全局唯一线程池？
 *
 */

@Component
public class SpringUtil {

    @Autowired
    private volatile ApplicationContext context;

    // 返回
    public static SpringUtil getInstance() {
        return Instance.getInstance();
    }

    /**
     * 静态内部类。单例模式。只希望该类的示例出现一次。
     *
     * 为什么里面要在里面加这些东西呢？
     */
    private static class Instance {

        private static final SpringUtil INSTANCE = new SpringUtil();

        public static SpringUtil getInstance() {
            return INSTANCE;
        }
    }

    /** 获取Spring容器中已初始化的bean */
    public <T> T getBean(Class<T> clazz) {
        if (context == null) {
            throw new IllegalStateException("未初始化 applicationContext");
        }
        return context.getBean(clazz);
    }

    public Object getBean(String name) {
        if (context == null) {
            throw new IllegalStateException("未初始化 applicationContext");
        }
        return context.getBean(name);
    }

    /** 获取Spring容器中已初始化的bean。但是这个name是什么作用呢？ */
    public <T> T getBean(String name, Class<T> clazz) {
        if (context == null) {
            throw new IllegalStateException("未初始化 applicationContext");
        }
        return context.getBean(name, clazz);
    }


    private SpringUtil() {
    }

    public ApplicationContext getContext() {
        return context;
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

}

