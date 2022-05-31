package com.demo.多线程;


import java.util.concurrent.locks.LockSupport;

public class TestDemo {


    public static void main(String[] args) throws Exception {

        Thread t2 = new Thread(()->{
            LockSupport.park();
            System.out.println("线程2执行");
        });

        Thread t1 = new Thread(()->{
            System.out.println("线程1执行");
            LockSupport.unpark(t2);
        });

        t2.start();
        t1.start();

    }
}

