package com.lyr.demo.decorate;

/**
 * Shirt实现装饰器父类
 */
public class Shirt extends ClothesDecorator implements Person{

    // 必须实现父类的构造方法
    public Shirt(Person person) {
        super(person);
    }

    // 花费的钱必须累加
    @Override
    public double cost() {
        return this.person.cost()+10;
    }

    @Override
    public void show() {
        // 展示之前的结果
        this.person.show();
        // 展示现在的结果
        System.out.println("买了一件Shirt，该Shirt花了10元，累计消费"+this.cost()+"元");
    }
}
