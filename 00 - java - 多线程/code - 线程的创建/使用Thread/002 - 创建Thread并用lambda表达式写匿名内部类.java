package com.demo.多线程.创建线程;

public class ThreadTest {
    public static void main(String[] args) {
        // 创建线程
        Thread thread = new Thread(()->
                System.out.println(Thread.currentThread().getName()) // 线程1
        );

        // 线程命名
        thread.setName("线程1");

        // 启动线程
        thread.start();

        // main线程
        System.out.println(Thread.currentThread().getName()); // main

    }

}
