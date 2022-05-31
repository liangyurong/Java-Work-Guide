package com.demo.设计模式.策略模式.计算器_纯策略模式;

import com.demo.设计模式.策略模式.计算器_纯策略模式.计算策略.AddStrategy;
import com.demo.设计模式.策略模式.计算器_纯策略模式.计算策略.DivStrategy;
import com.demo.设计模式.策略模式.计算器_纯策略模式.计算策略.MulStrategy;
import com.demo.设计模式.策略模式.计算器_纯策略模式.计算策略.SubStrategy;

// 计算上下文
public class CalContext {

    private CalStrategy calStrategy;

    public CalContext(CalStrategy calStrategy){
        this.calStrategy = calStrategy;
    }

    // 新增一种计算策略，则必须在switch中添加代码
    public static CalStrategy getCalStrategyByCalType(CalType calType){
        CalStrategy calStrategy = null;
        switch (calType){
            case ADD:
                calStrategy = new AddStrategy();
                break;
            case SUB:
                calStrategy = new SubStrategy();
                break;
            case MUL:
                calStrategy = new MulStrategy();
                break;
            case DIV:
                calStrategy = new DivStrategy();
                break;
            default:
                break;
        }
        return calStrategy;
    }

}
