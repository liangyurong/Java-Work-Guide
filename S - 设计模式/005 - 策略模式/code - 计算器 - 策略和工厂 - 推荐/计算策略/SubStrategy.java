package com.demo.设计模式.策略模式.计算器_策略和工厂.计算策略;

import com.demo.设计模式.策略模式.计算器_策略和工厂.config.CalMethod;
import com.demo.设计模式.策略模式.计算器_策略和工厂.CalStrategy;
import org.springframework.stereotype.Service;

@CalMethod(value = "sub",desc = "减法")
@Service
public class SubStrategy implements CalStrategy {
    @Override
    public int calculate(int num1, int num2) {
        return num1-num2;
    }
}
