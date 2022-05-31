package com.demo.设计模式.策略模式.鸭子.抽象类;

import com.demo.设计模式.策略模式.鸭子.策略接口.FlyBehavior;
import com.demo.设计模式.策略模式.鸭子.策略接口.SwimBehavior;

public abstract class Duck {

    protected FlyBehavior flyBehavior;

    protected SwimBehavior swimBehavior;

    public Duck(){}

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setSwimBehavior(SwimBehavior swimBehavior) {
        this.swimBehavior = swimBehavior;
    }

    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public SwimBehavior getSwimBehavior() {
        return swimBehavior;
    }

    public void fly(){
        flyBehavior.fly();
    }

    public void swim(){
        swimBehavior.swim();
    }

}
