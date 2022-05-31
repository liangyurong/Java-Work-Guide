package com.demo.设计模式.策略模式.计算器_策略和工厂;

import com.demo.设计模式.策略模式.计算器_策略和工厂.config.CalStrategyAnnotationParseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalService {

    @Autowired
    private CalStrategyAnnotationParseFactory factory;

    public int select(String inputVal){
        int num1=10;
        int num2=3;
        CalStrategy strategy = factory.getStrategy(inputVal);
        int result = strategy.calculate(num1, num2);
        return result;
    }

}
