package com.demo.多线程.threadlocal;

/**
 * 线程不隔离，导致访问的content变量是脏的
 *  Thread-1---> Thread-25的数据
 *  Thread-3---> Thread-25的数据
 *  Thread-24---> Thread-45的数据
 *  Thread-18---> Thread-46的数据
 */
public class TestThreadLocal {

    public static void main(String[] args){
        TestThreadLocal en = new TestThreadLocal();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                en.setContent(Thread.currentThread().getName()+"的数据");
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"---> "+en.getContent());
            }).start();
        }
    }

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
