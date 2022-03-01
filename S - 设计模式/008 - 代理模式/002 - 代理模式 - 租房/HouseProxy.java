package com.sdyb.aiyimei.test;

/**
 * 找房中介，代理
 */
public class HouseProxy implements House{

    private House house;

    public HouseProxy(House house){
        this.house = house;
    }

    @Override
    public void findHouse() {

        // 这里可以写其他的非业务代码
        System.out.println("找了一个代理去找房子");

        // 业务代码
        this.house.findHouse();
    }
}
