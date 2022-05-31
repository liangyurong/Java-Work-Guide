package com.demo.设计模式.策略模式.计算器_策略和工厂;

import com.demo.设计模式.策略模式.计算器_策略和工厂.计算策略.AddStrategy;
import com.demo.设计模式.策略模式.计算器_策略和工厂.计算策略.DivStrategy;
import com.demo.设计模式.策略模式.计算器_策略和工厂.计算策略.MulStrategy;
import com.demo.设计模式.策略模式.计算器_策略和工厂.计算策略.SubStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例工厂
 */
public class CalSingleFactory {

    // 使用map
    private static Map<CalType, CalStrategy> calMap = new HashMap<>();

    static {
        calMap.put(CalType.ADD,new AddStrategy());
        calMap.put(CalType.SUB,new SubStrategy());
        calMap.put(CalType.MUL,new MulStrategy());
        calMap.put(CalType.DIV,new DivStrategy());
    }

    public static CalStrategy getCalStrategy(CalType calType){
        return calMap.get(calType);
    }

}
