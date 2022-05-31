package com.demo.多线程.创建线程;


public class Test {

    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(()->{
            synchronized (Test.class){
                while (true){
                    // 死循环
                }
            }
        },"t1");

        Thread t2 = new Thread(()->{
            synchronized (Test.class){
                System.out.println("t2线程获取到了对象锁");
            }
        },"t2");

        t1.start();
        Thread.sleep(1000); // main线程先休眠，保证先执行t1线程
        t2.start();

        System.out.println("t1状态 ： "+t1.getState()); // RUNNABLE
        System.out.println("t2状态 ： "+t2.getState()); // BLOCKED，t2获取不到对象锁，陷入阻塞

        // t2线程尝试获取对象锁，但是对象锁被t1线程持有，因此t2线程陷入阻塞，此时t2线程还没进同步代码块

    }

}

