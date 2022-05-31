package com.demo.多线程;

import java.util.concurrent.locks.ReentrantLock;

// 没有获取到锁，进入阻塞，用interupt()打断阻塞，从而继续执行
public class TestDemo {

    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws Exception {


        Thread t1 = new Thread(()->{
            try{
                // 获取锁
                // 如果没有竞争，那么此方法会获得锁
                // 如果有竞争，就会进入阻塞队列，可以被其他线程用interrupt方法打断
                System.out.println("尝试获取锁");
                reentrantLock.lockInterruptibly();
            }catch (Exception e){
                System.out.println("获取锁失败，捕获异常："+e.toString());
                return;
            }

            try{
                System.out.println("获取到锁");
            }finally {
                reentrantLock.unlock();
            }

        },"t1");

        reentrantLock.lock();
        t1.start();

        Thread.sleep(100);

        System.out.println("打断锁");
        t1.interrupt();


    }

}

