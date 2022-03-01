package com.lyr.demo.decorate;

/**
 * 被装饰的对象
 */
public class YuRong333 implements Person {
    @Override
    public double cost() {
        return 0.0;
    }

    @Override
    public void show() {
        System.out.println("没穿衣服的yurong333");
    }
}
