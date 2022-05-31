package com.demo.设计模式.观察者模式.订阅报纸.订阅者;

public class CustomerA extends NewsCustomer{
    @Override
    public void getNewspaper() {
        System.out.println("顾客A收到了报纸");
    }
}
