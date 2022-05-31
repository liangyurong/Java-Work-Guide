package com.demo.多线程.创建线程;

public class Test {
    public static void main(String[] args) throws Exception{

        Thread t2 = new Thread(()->{
            while (true){

            }
        },"t2");

        t2.start();
        Thread.sleep(1000);
        t2.interrupt();
        System.out.println(t2.getState());       // RUNNABLE
        System.out.println(t2.isInterrupted());  // true

    }
}

