package com.lyr.demo.策略模式.quack;

public class squeak implements  QuackBehavior {
    @Override
    public void quack() {
        System.out.println("吱吱吱");
    }
}
