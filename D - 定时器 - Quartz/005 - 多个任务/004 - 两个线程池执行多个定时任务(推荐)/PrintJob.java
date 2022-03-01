package com.sdyb.aiyimei.job;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@EnableAsync
public class PrintJob {
    // 该@Async注解是可以指定使用哪个线程池的。这样就可以在不同的线程池中执行不同的定时任务了
    // 使用线程池1
    @Scheduled(fixedRate = 3000)
    @Async("executor1")
    public void printTest1(){
        // 打印方法和当前线程名称
        System.out.println("1run --> "+new Date()+" "+Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1 end --> "+new Date());
    }

    // 该@Async注解是可以指定使用哪个线程池的。这样就可以在不同的线程池中执行不同的定时任务了
    // 使用线程池2
    @Scheduled(fixedRate = 3000)
    @Async("executor2")
    public void printTest2(){
        System.out.println("2 run --> "+new Date()+" "+Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("2 end --> "+new Date());
    }

}
