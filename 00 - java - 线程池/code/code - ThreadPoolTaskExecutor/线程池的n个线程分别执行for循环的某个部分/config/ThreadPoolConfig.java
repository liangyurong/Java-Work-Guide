package com.sdyb.mp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync // 开启对异步的支持
public class ThreadPoolConfig {

    /**
     * 配置第1个线程池
     */
    @Bean("executor1") // 线程池名称
    public Executor executor1() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("线程池1：");
        executor.setMaxPoolSize(20);  // 最大线程
        executor.setCorePoolSize(15); // 核心线程
        executor.setQueueCapacity(0); // 队列容量
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

}
