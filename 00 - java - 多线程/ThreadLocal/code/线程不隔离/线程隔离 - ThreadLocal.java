package com.demo.多线程.threadlocal;

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

    // 关键操作：声明ThreadLocal，在content的set和get方法上进行修改
    ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private String content;

    public String getContent() {
        return threadLocal.get();
    }

    public void setContent(String content) {
        threadLocal.set(content);
    }



}
