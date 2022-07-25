package com.demo.多线程;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TestDemo {

    private static final ReentrantLock lockA = new ReentrantLock();
    private static final ReentrantLock lockB = new ReentrantLock();

    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(() -> {
            if(!lockA.tryLock()){
                System.out.println(Thread.currentThread().getName()+"获取lockA失败");
                return;
            }
            try{
                System.out.println(Thread.currentThread().getName() + "获得了lockA");
                if(!lockB.tryLock(3, TimeUnit.SECONDS)){
                    System.out.println(Thread.currentThread().getName()+"获取lockB失败");
                    return;
                }

                try{
                    System.out.println(Thread.currentThread().getName() + "获得了lockB");
                }finally {
                    lockB.unlock();
                }

            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                lockA.unlock();
            }
        },"线程A");

        Thread t2 = new Thread(() -> {
            if(!lockB.tryLock()){
                System.out.println(Thread.currentThread().getName()+"获取锁B失败");
                return;
            }
            try{
                System.out.println(Thread.currentThread().getName() + "获得了lockB");
                if(!lockA.tryLock(2, TimeUnit.SECONDS)){
                    System.out.println(Thread.currentThread().getName()+"获取lockA失败");
                    return;
                }
                try{
                    System.out.println(Thread.currentThread().getName() + "获得了lockA");
                }finally {
                    lockA.unlock();
                }

            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                lockB.unlock();
            }
        },"线程B");


        t1.start();
        t2.start();

    }

}

