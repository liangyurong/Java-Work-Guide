package com.demo.多线程.创建线程;

public class Test {
    public static void main(String[] args) throws Exception{
//        Thread t1 = new Thread(()->{},"t1");
//        t1.start();
//        t1.interrupt();                          // 对t1线程打上中断标志
//        System.out.println(t1.isInterrupted());  // true
//        System.out.println(Thread.currentThread().isInterrupted()); // main线程没被打上中断标志，因此返回false

        Thread t2 = new Thread(()->{},"t2");
        t2.start();
        Thread.sleep(1000);
        t2.interrupt();
        System.out.println(t2.getState());       // TERMINATED ， 线程执行完会将打算标志重新设置为false吗
        System.out.println(t2.isInterrupted());  // false

    }
}

