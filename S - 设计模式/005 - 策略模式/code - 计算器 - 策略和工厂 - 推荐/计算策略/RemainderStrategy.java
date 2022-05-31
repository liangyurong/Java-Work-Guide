package com.demo.设计模式.策略模式.计算器_策略和工厂.计算策略;

import com.demo.设计模式.策略模式.计算器_策略和工厂.CalStrategy;
import com.demo.设计模式.策略模式.计算器_策略和工厂.config.CalMethod;
import org.springframework.stereotype.Service;

@CalMethod(value = "re",desc = "取余")
@Service
public class RemainderStrategy implements CalStrategy {
    @Override
    public int calculate(int num1, int num2) {
        return num1%num2;
    }
}
