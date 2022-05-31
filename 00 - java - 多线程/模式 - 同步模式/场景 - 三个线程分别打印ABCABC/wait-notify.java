package com.demo.多线程;

public class TestDemo {

    public static void main(String[] args) throws Exception {

        WaitNotify waitNotify = new WaitNotify("A", 5);

        Thread t1 = new Thread(()->{
            waitNotify.print("A","B");
        });

        Thread t2 = new Thread(()->{
            waitNotify.print("B","C");
        });

        Thread t3 = new Thread(()->{
            waitNotify.print("C","A");
        });

        t1.start();
        t2.start();
        t3.start();

    }
}

class WaitNotify{

    // 打印标记
    private String flag;

    // 循环次数
    private int loopNum;

    public WaitNotify(String flag,int loopNum){
        this.flag = flag;
        this.loopNum = loopNum;
    }

    // 当前打印标记，下一个打印标记
    public void print(String curFlag,String nextFlag){
        for (int i = 0; i < loopNum; i++) {
            synchronized (this){
                while(!curFlag.equals(flag)){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(flag);
                flag = nextFlag;
                this.notifyAll();
            }
        }
    }

}

