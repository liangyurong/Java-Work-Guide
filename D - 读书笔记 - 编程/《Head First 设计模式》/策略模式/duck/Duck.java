package com.lyr.demo.策略模式.duck;

import com.lyr.demo.策略模式.fly.FlyBehavior;
import com.lyr.demo.策略模式.quack.QuackBehavior;

/**
 * 鸭子抽象类
 */
public abstract class Duck {

    private FlyBehavior flyBehavior;

    private QuackBehavior quackBehavior;

    public Duck() {
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println(" all ducks float , even decoys");
    }

}
