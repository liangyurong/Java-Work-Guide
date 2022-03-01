package com.sdyb.aiyimei.job;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 在类添加@EnableAsync注解
 * 在方法上添加@Async注解，
 */
@Component
@EnableAsync
public class PrintJob {

    /**
     * 两个方法，不管执行哪个方法，都会生成一个新的线程去执行，这样子非常浪费服务器资源
     */
    @Scheduled(fixedRate = 3000)
    @Async
    public void printTest1(){
       System.out.println("1 run --> "+new Date());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1 end --> "+new Date());
    }

    @Scheduled(fixedRate = 3000)
    @Async
    public void printTest2(){
        System.out.println("2 run --> "+new Date());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("2 end --> "+new Date());
    }

}
