package com.demo.多线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// 两个线程分别对应不同的条件变量
public class TestDemo {

    static boolean hasCigarette = false;
    static boolean hasTakeout = false;

    static ReentrantLock ROOM = new ReentrantLock();

    // 创建新的条件变量（等烟休息室）
    static Condition waitCigaretteSet = ROOM.newCondition();
    // 创建新的条件变量（等外卖休息室）
    static Condition waitTakeoutSet = ROOM.newCondition();

    public static void main(String[] args) throws Exception {

        // 等烟线程
        new Thread(()->{
            ROOM.lock();
            try {
                System.out.println("烟是否送到："+ hasCigarette);
                while (!hasCigarette){
                    try {
                        System.out.println(Thread.currentThread().getName()+" : 没有烟，先休息");
                        waitCigaretteSet.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+" : 烟到了，开始干活");
            }finally {
                ROOM.unlock();
            }
        },"等烟线程").start();

        // 等外卖线程
        new Thread(()->{
            ROOM.lock();
            try {
                System.out.println("外卖是否送到："+ hasTakeout);
                while (!hasTakeout){
                    try {
                        System.out.println(Thread.currentThread().getName()+" : 没有外卖，先休息");
                        waitTakeoutSet.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+" : 外卖到了，开始干活");
            }finally {
                ROOM.unlock();
            }
        },"等烟线程").start();

        Thread.sleep(100);
        // 送烟线程
        new Thread(()->{
            ROOM.lock();
            try{
                hasCigarette = true;
                waitCigaretteSet.signalAll();
            }finally {
                ROOM.unlock();
            }
        },"送烟").start();

        Thread.sleep(100);
        // 送外卖线程
        new Thread(()->{
            ROOM.lock();
            try{
                hasTakeout = true;
                waitTakeoutSet.signalAll();
            }finally {
                ROOM.unlock();
            }
        },"送外卖").start();

    }
}

/**
 * 烟是否送到：false
 * 等烟线程 : 没有烟，先休息
 * 外卖是否送到：false
 * 等烟线程 : 没有外卖，先休息
 * 等烟线程 : 烟到了，开始干活
 * 等烟线程 : 外卖到了，开始干活
 */

