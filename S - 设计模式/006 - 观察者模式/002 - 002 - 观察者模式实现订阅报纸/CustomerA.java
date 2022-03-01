package com.lyr.demo.decorate;

/**
 * 观察者实体类
 */
public class CustomerA extends Customer {
    @Override
    public void getNewspaper() {
        System.out.println("A顾客收到了新报纸");
    }
}
