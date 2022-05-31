package com.demo.多线程.创建线程;

public class Test {

     static int a = 0;

    public static void main(String[] args) throws Exception{

        Thread t1 = new Thread(()->{
            synchronized (Test.class){
                for (int i = 0; i < 5000; i++) {
                    a--;
                }
            }
        },"t1");

        Thread t2 = new Thread(()->{
            synchronized (Test.class){
                for (int i = 0; i < 5000; i++) {
                    a++;
                }
            }
        },"t2");

        t1.start();
        t2.start();

        Thread.sleep(1000);

        System.out.println("a = "+a); // 0

    }
}

