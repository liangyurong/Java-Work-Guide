package com.lyr.demo.观察者模式.接口;

/**
 * 主题
 */
public interface Subject {

    /**
     * 注册观察者
     */
    void registerObserver(Observer obs);

    /**
     * 删除观察者
     */
    void removeObserver(Observer obs);

    /**
     * 在状态改变时，更新所有的当前观察者
     */
    void notifyObservers();

}
