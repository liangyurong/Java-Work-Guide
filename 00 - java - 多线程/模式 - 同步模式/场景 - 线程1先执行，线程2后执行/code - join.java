package com.demo.多线程;

import javafx.beans.binding.BooleanExpression;

public class TestDemo {

    static final Object lock = new Object();

    // 线程1是否已执行
    static Boolean run1 = false;

    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(()->{
            System.out.println("线程1已执行");
        });

        Thread t2 = new Thread(()->{
            System.out.println("线程2已执行");
        });

        t1.start();
        t1.join(); // 等到t1线程执行完
        t2.start();

    }
}

