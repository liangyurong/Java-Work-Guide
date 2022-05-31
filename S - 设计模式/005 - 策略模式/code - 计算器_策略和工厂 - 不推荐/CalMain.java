package com.demo.设计模式.策略模式.计算器_策略和工厂;

public class CalMain {
    public static void main(String[] args) {

        int num1 = 10;
        int num2 = 2;

        CalStrategy calStrategy = CalSingleFactory.getCalStrategy(CalType.ADD);
        int add = calStrategy.calculate(num1, num2);

    }
}
