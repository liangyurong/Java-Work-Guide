package com.lyr.demo.观察者模式.接口;

/**
 * 观察者
 */
public interface Observer {
    /**
     * 当气象观测值改变时，主题会把这些状态值当做方法的参数，传递给观察者
     * @param temp 温度
     * @param hunidity 湿度
     * @param pressure 气压
     */
    void update(float temp,float hunidity,float pressure);
}
