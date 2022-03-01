package com.lyr.demo.decorate;

/**
 * 装饰器和被装饰的对象的统一接口
 */
public interface Person {

    /** 花了多少钱 */
    double cost();

    /** 买了什么衣服 */
    void show();

}
