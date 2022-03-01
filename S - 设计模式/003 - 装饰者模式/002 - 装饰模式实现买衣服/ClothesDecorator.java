package com.lyr.demo.decorate;

/**
 * 装饰器父类
 */
public abstract class ClothesDecorator implements Person {

    // 不可使用private
    protected Person person;

    ClothesDecorator(Person person){
        this.person = person;
    }



}
