package com.lyr.demo.观察者模式;

import java.util.Observable;
import java.util.Observer;

/**
 * 天气数据类
 */
public class WeatherData extends Observable {

    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(){}

    /**
     *
     */
    public void measurementsChanged(){
        setChanged(); // 在调用notifyObservers()之前，需要setChanged()指示状态已经改变。
        notifyObservers();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

}
