/**
 * 这里只有一个@Component注解
 */

package com.sdyb.aiyimei.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PrintJob {

    @Scheduled(fixedRate = 3000)
    public void printTest1(){
       System.out.println("1: hello run --> "+new Date());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1: hello end --> "+new Date());
        System.out.println();
    }

    @Scheduled(fixedRate = 3000)
    public void printTest2(){
        System.out.println("2: hello run --> "+new Date());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("2: hello end --> "+new Date());
        System.out.println();
    }

}
