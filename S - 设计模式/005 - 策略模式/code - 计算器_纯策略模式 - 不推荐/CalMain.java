package com.demo.设计模式.策略模式.计算器_纯策略模式;

public class CalMain {
    public static void main(String[] args) {

        int num1 = 10;
        int num2 = 2;

        int type1 = 1; // 前端传递的计算类型
        CalType calType1 = CalType.getCalTypeByType(type1);
        CalStrategy calStrategy1 = CalContext.getCalStrategyByCalType(calType1);
        int result1 = calStrategy1.calculate(num1, num2);

        int type2 = 2; // 前端传递的计算类型
        CalType calType2 = CalType.getCalTypeByType(type2);
        CalStrategy calStrategy2 = CalContext.getCalStrategyByCalType(calType2);
        int result2 = calStrategy2.calculate(num1, num2);



    }
}
