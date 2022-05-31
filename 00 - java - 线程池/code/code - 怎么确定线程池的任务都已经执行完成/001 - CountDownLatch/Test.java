package com.demo.线程池.手动创建线程池;

import java.util.concurrent.*;

public class Test {

    private static int RESULT = 0;

    public static void main(String[] args) {

        // 线程池
        ThreadPoolExecutor exe = new ThreadPoolExecutor(3, 10, 1L
                ,TimeUnit.SECONDS
                ,new ArrayBlockingQueue<>(3)
                ,Executors.defaultThreadFactory()
                ,new ThreadPoolExecutor.AbortPolicy());

        // 任务数量
        int taskCount = 10;

        // 单次计数器
        CountDownLatch countDownLatch = new CountDownLatch(taskCount);

        // 执行任务
        for (int i = 0; i <taskCount; i++) {
            final int a = i;
            exe.execute(() -> {
                getSum(a);
                countDownLatch.countDown(); // 执行一次，则计数器-1
                if(0==countDownLatch.getCount()){ // 当计数器为0，说明执行完成
                    System.out.println("1+2+...+100 = "+RESULT);
                }
            });
        }

        // 关闭线程池(在实际开发中，一般不会主动去关闭线程池)
        exe.shutdown();
    }

    // 使用10个线程
    // 计算 1+2+..+10
    // 计算 11+12+..+20
    // 计算 21+22+..+30
    // ...
    // 计算 91+92+...+100
    public static void getSum(int num){
        int start = num*10+1;
        int end = (num+1)*10;
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum+=i;
        }
        RESULT+=sum;
    }

}
