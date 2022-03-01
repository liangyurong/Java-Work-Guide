package com.lyr.demo.策略模式.quack;

public class Qucak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("嘎嘎嘎");
    }
}
