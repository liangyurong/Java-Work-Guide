package com.lyr.demo.策略模式.fly;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("i can not fly");
    }
}
