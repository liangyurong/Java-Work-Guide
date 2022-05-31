package com.lyr.demo.decorate;

public class Client {
    public static void main(String[] args) {
        ComputerFactory  factory = new ComputerFactory();

        // 需要电脑，不需要自己制造电脑，直接从工厂获取一台电脑
        Computer a = factory.createComputer("a");
        Computer b = factory.createComputer("b");
    }
}
