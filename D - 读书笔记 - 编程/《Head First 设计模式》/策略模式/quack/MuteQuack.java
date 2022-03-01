package com.lyr.demo.策略模式.quack;

public class MuteQuack implements  QuackBehavior {
    @Override
    public void quack() {
        System.out.println("silence silence silence");
    }
}
