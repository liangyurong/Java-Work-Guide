package com.demo.多线程.创建线程;

public class Test {
    public static void main(String[] args) throws Exception{

        Thread t2 = new Thread(()->{
            Thread.interrupted(); // 打上中断标志，但是会重置为false
            while (true){

            }
        },"t2");
        t2.start();
        Thread.sleep(1000);
        t2.interrupt();
        System.out.println(t2.getState());       // RUNNABLE
        System.out.println(t2.isInterrupted());  // false

    }
}

