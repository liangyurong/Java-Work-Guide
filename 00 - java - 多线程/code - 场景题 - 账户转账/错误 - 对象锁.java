package com.demo.多线程.三个串口同时卖100张票;

import java.util.Random;


// 结果错误分析
    // synchronized(this)，锁住的是对象锁，在两个线程中的transfer()方法，一个锁住的是a对象，一个锁住的是b对象，因此没有造成互斥

public class Test {

    public static void main(String[] args) throws Exception{

        Account a = new Account(1000);
        Account b = new Account(1000);

        // 创建两个线程，进行转账
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                a.transfer(b,getRandomAmount()); // a向b转账
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                b.transfer(a,getRandomAmount()); // b向a转账
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("最终的两个账户总额 = " + (a.getMoney()+b.getMoney()));

    }

    public static int getRandomAmount(){
        return new Random().nextInt(100)+1;
    }

}


// 账户
class Account {

    private int money = 0;

    public Account(int money){
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    // 转账
    public  void transfer(Account target,int amount) {
        synchronized (this){
            if(this.money>=amount){
                this.setMoney(money-amount);
                target.setMoney(target.getMoney()+amount);
            }
        }
    }

}
