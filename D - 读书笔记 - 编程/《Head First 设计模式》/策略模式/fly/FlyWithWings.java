package com.lyr.demo.策略模式.fly;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("i am flying");
    }
}
