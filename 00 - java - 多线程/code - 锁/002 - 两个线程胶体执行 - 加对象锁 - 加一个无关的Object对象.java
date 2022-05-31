package com.demo.多线程.创建线程;

// t1线程获取到lock对象锁，执行代码，如果此时t2线程尝试获取对象锁，则会被阻塞（blocked）
// 当t1线程执行完代码，系统唤醒被阻塞的t2线程，则t2线程才有机会获取cpu时间片执行代码，但不一定能获取到，有可能t1线程能够继续获取到cpu时间片

// 被阻塞的线程，是不会分配到cpu时间片的

// a是多个线程的共享资源

// synchronized实际是用对象锁保证了临界区内的代码的原子性，临界区内的代码对外是不可分割的，不会被线程切换所打断
public class Test {

    static int a = 0;

    private static Object lock = new Object();

    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (lock) {
                    // 一个代码块内如果存在对共享资源的多线程读写操作，那么该代码块被称为临界区
                    a--;
                    System.out.println(Thread.currentThread().getName()+" -->  a = "+a);
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (lock) {
                    a++;
                    System.out.println(Thread.currentThread().getName()+" -->  a = "+a);
                }
            }
        }, "t2");

        t1.start();
        t2.start();

        Thread.sleep(1000);             // main线程休眠，让t1,t2线程有机会获取cpu时间片去执行代码

        System.out.println("a = " + a); // 0

    }
}

