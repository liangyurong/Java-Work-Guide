package com.demo.多线程;

import javafx.beans.binding.BooleanExpression;

public class TestDemo {

    static final Object lock = new Object();

    // 线程1是否已执行
    static Boolean run1 = false;

    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(()->{
            synchronized (lock){
                System.out.println("线程1已执行");
                run1 = true;
                lock.notifyAll();
            }
        });

        Thread t2 = new Thread(()->{
            synchronized (lock){
                while (!run1){ // while循环，避免虚假唤醒
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程2已执行");
            }
        });

        t2.start();
        t1.start();

    }
}

