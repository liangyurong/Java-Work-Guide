package com.lyr.demo.decorate;

public class TestMain {
    public static void main(String[] args) {

        Person yurong333 = new YuRong333();

        // 装饰器当中要使用被装饰的对象，而不是被装饰的对象使用装饰器
        yurong333 = new Shirt(yurong333);
        yurong333 = new Pants(yurong333);

        yurong333.show();
        System.out.println("总共消费了" + yurong333.cost() + "元");
    }
}
