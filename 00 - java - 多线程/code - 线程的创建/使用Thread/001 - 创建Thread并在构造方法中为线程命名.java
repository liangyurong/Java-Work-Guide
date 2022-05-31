package com.demo.多线程.创建线程;

/**
 * 使用Thread的匿名内部类创建任务，则线程和任务是耦合的
 */
public class ThreadTest {
    public static void main(String[] args) {
        // 创建线程
        Thread thread = new Thread("线程1"){
            @Override
            public void run() {
                // 任务
                System.out.println(Thread.currentThread().getName()); // 线程1
            }
        };

        // 启动线程
        thread.start();

        // main线程
        System.out.println(Thread.currentThread().getName()); // main

    }

}
