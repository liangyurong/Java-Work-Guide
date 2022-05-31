package com.demo.设计模式.观察者模式.订阅报纸.订阅者;

public class CustomerB extends NewsCustomer{
    @Override
    public void getNewspaper() {
        System.out.println("顾客B收到了报纸");
    }
}

