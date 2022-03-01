package com.lyr.demo.decorate;

public class TestMain {
    public static void main(String[] args) {

        // 创建被观察者
        NewspaperOffice newspaperOffice = new NewspaperOffice();

        // 创建观察者
        Customer customerA = new CustomerA();
        Customer customerB = new CustomerB();

        // 将观察者添加到被观察者
        newspaperOffice.AddCustomer(customerA);
        newspaperOffice.AddCustomer(customerB);

        // 当被观察者有新报纸，通知所有订阅的观察者
        newspaperOffice.addNewspaper();

    }
}
