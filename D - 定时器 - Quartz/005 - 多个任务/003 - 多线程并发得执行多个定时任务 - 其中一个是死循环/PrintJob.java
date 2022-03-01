package com.sdyb.aiyimei.job;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@EnableAsync
public class PrintJob {

    // 死循环方法
    @Scheduled(fixedRate = 3000)
    @Async
    public void printTest1(){
    System.out.println("1 run --> "+new Date());
    int num = 1;
    int s = 2;
    for (int i = 1; num < s; i++) {

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
