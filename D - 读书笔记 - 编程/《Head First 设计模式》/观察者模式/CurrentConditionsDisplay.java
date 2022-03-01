package com.lyr.demo.观察者模式;

import com.lyr.demo.观察者模式.接口.DisplayElement;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(Observable observable){
        this.observable=observable;
        observable.addObserver(this);
    }

    /**
     * 重写Observer接口的update()方法
     * @param obs
     * @param arg
     */
    @Override
    public void update(Observable obs, Object arg) {
        if(obs instanceof WeatherData ){
            WeatherData weatherData = (WeatherData)obs;
            this.temperature=weatherData.getTemperature();
            this.humidity=weatherData.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("temperature="+temperature+",humidity="+humidity);
    }
}
