package com.lyr.demo.decorate;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者
 */
public class NewspaperOffice {

    // 被观察者存储所有的观察者信息
    private List<Customer> customers = new ArrayList<>();

    // 添加订阅者
    public void AddCustomer(Customer customer){
        customers.add(customer);
    }

    // 通知方法，通知所有的观察者
    private void notifyAllObservers(){
        for (Customer customer : customers) {
            customer.getNewspaper();
        }
    }

    // 当新报纸来的时候，发送给观察者
    public void addNewspaper(){
        this.notifyAllObservers();
    }

}
