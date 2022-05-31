package com.demo.多线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestDemo {

    static ReentrantLock LOCK = new ReentrantLock();

    static Condition waitSet = LOCK.newCondition();

    // 线程1是否已执行
    static Boolean run1 = false;

    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(()->{
            LOCK.lock();
            try {
                System.out.println("线程1已执行");
                run1 = true;
                waitSet.signalAll(); 唤醒等带
            }finally {
                LOCK.unlock();
            }
        });

        Thread t2 = new Thread(()->{
            LOCK.lock();
            try {
                while (!run1){
                    try {
                        waitSet.await(); // 进入等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程2已执行");
            }finally {
                LOCK.unlock();
            }
        });


        t2.start();
        t1.start();

    }
}

