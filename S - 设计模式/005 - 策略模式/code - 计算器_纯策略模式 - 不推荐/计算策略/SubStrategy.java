package com.demo.设计模式.策略模式.计算器_纯策略模式.计算策略;

import com.demo.设计模式.策略模式.计算器_纯策略模式.CalStrategy;

public class SubStrategy implements CalStrategy {
    @Override
    public int calculate(int num1, int num2) {
        return num1-num2;
    }
}
