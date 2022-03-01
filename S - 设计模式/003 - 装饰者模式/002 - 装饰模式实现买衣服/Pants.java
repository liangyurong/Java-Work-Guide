package com.lyr.demo.decorate;

/**
 * Pants实现装饰器父类
 */
public class Pants extends ClothesDecorator implements Person{

    public Pants(Person person) {
        super(person);
    }

    @Override
    public double cost() {
        return this.person.cost()+20;
    }

    @Override
    public void show() {
        this.person.show();
        System.out.println("买了一件Pants，该Pants花了20元，累计消费"+this.cost()+"元");
    }
}
