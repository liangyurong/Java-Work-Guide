package com.sdyb.mp.module.策略模式实现计算器;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {

    @Autowired
    private Calculator calculator;

    public void test() {
        // 加、减、乘、除
        int add = calculator.calculate(CalEnum.ADD.getCode(), 10, 2);
        int sub = calculator.calculate(CalEnum.SUB.getCode(), 10, 2);
        int mul = calculator.calculate(CalEnum.MUL.getCode(), 10, 2);
        int div = calculator.calculate(CalEnum.DIV.getCode(), 10, 2);
    }
}
