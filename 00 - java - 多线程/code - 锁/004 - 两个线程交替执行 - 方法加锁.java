package com.demo.多线程.创建线程;

public class Test {

    private static int a = 0;

    public static void main(String[] args) throws Exception{

        Thread t1 = new Thread(()->{
                for (int i = 0; i < 5000; i++) {
                    decrement();
                }
        },"t1");

        Thread t2 = new Thread(()->{
                for (int i = 0; i < 5000; i++) {

                    increment();
                }
        },"t2");

        t1.start();
        t2.start();

        Thread.sleep(1000);           // main线程休眠，让t1,t2线程有机会获取cpu时间片去执行代码

        System.out.println("a = "+a); // 0

    }

    // 方法加锁，锁住的是什么？相当于synchronized(this)
    // 一般不要在方法加锁，因为有些不是临界区的代码，可以放在syn的外面
    public synchronized static void increment(){
        a++;
    }

    public synchronized static void decrement(){
        a--;
    }

}

