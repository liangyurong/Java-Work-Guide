package com.demo.设计模式.观察者模式.订阅报纸;

import com.demo.设计模式.观察者模式.订阅报纸.发布者.NewspaperOffice;
import com.demo.设计模式.观察者模式.订阅报纸.订阅者.*;

public class ObserverMain {
    public static void main(String[] args) {
        // 创建被观察者
        NewspaperOffice newspaperOffice = new NewspaperOffice();

        // 创建观察者
        NewsCustomer customerA = new CustomerA();
        NewsCustomer customerB = new CustomerB();

        // 将观察者添加到被观察者
        newspaperOffice.AddCustomer(customerA);
        newspaperOffice.AddCustomer(customerB);

        // 当被观察者有新报纸，通知所有订阅的观察者
        newspaperOffice.notifyAllObservers();
    }
}
