package com.lyr.demo.util;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 线程池
 */
public class ThreadPoolUtil {
    /**  */
    private static ThreadPoolTaskExecutor threadPoolTaskExecutor;
    /** 队列最大长度 */
    private static int queueCapacity = 100000;
    /** 核心线程数 */
    private static int corePoolSize = 2;
    /** 最大线程数 */
    private static int maxPoolSize = 10;
    /** 线程池维护线程所允许的空闲时间 */
    private static int KeepAliveSeconds = 30;

    public static synchronized ThreadPoolTaskExecutor getThreadPoolTaskExecutor() {
        if (threadPoolTaskExecutor == null) {
            threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
            threadPoolTaskExecutor.setQueueCapacity(queueCapacity);
            threadPoolTaskExecutor.setCorePoolSize(corePoolSize);
            threadPoolTaskExecutor.setMaxPoolSize(maxPoolSize);
            threadPoolTaskExecutor.setKeepAliveSeconds(KeepAliveSeconds);
            threadPoolTaskExecutor.initialize();
        }
        return threadPoolTaskExecutor;
    }
}

