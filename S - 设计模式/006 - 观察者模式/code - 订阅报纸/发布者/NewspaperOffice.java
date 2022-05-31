package com.demo.设计模式.观察者模式.订阅报纸.发布者;

import java.util.ArrayList;
import java.util.List;
import com.demo.设计模式.观察者模式.订阅报纸.订阅者.*;

/**
 * 被观察者
 */
public class NewspaperOffice {

    // 被观察者存储所有的观察者信息
    private List<NewsCustomer> customers = new ArrayList<>();

    // 添加订阅者
    public void AddCustomer(NewsCustomer customer){
        customers.add(customer);
    }

    // 通知方法:当新报纸来的时候,通知所有的观察者
    public void notifyAllObservers(){
        customers.forEach(customer -> customer.getNewspaper());
    }

}
