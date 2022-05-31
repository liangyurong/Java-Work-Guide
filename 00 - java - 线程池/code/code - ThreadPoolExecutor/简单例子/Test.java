package com.demo.线程池.手动创建线程池;

import java.util.concurrent.*;

// 手动创建线程池并执行
public class Test {
    public static void main(String[] args) {

        // 等待队列 : new ArrayBlockingQueue<>(3)
        // 线程工厂 : Executors.defaultThreadFactory()
        // 拒绝策略 : new ThreadPoolExecutor.AbortPolicy()
        ThreadPoolExecutor exe = new ThreadPoolExecutor(3, 5, 1L,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(3),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i <9; i++) {
            exe.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " : 执行-> ");
                }
            });
        }
        exe.shutdown();

    }
}
