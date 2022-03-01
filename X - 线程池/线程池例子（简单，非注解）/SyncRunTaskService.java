package com.lyr.demo.service;

import com.lyr.demo.service.impl.TestServiceImpl;
import com.lyr.demo.util.SpringUtil;

/**
 *  异步计算
 */
public class SyncRunTaskService implements Runnable {

    private String num;

    public SyncRunTaskService(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public void run() {
        // 为什么不能用@AutoWired呢？
        TestServiceImpl testServiceImpl = SpringUtil.getInstance().getBean(TestServiceImpl.class);
        // 计算
        try {
            testServiceImpl.sout(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

