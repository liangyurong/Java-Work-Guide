package com.demo.多线程.创建线程;

// 打断正常执行的线程，线程的打断标志为true，同时线程会继续执行，不会被打断
public class JoinTest {

    private static int val = 1;

    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(()->{
            while (true){
                System.out.println("------> "+(val++));
                if(Thread.currentThread().isInterrupted()){ // 打断标志是否为true
                    break;
                }
            }
        },"线程1");

        t1.start();              // 启动线程1
        Thread.sleep(10);        // main线程休眠0.1s
        t1.interrupt();          // main线程执行该行代码，线程1的执行被打断，但不抛出异常
    }

}
