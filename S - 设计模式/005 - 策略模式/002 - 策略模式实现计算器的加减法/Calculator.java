package com.sdyb.mp.module.策略模式实现计算器;

import org.springframework.stereotype.Component;

/**
 * 计算器
 */
@Component
public class Calculator {

    public int calculate(int code,int num1,int num2){
        CalEnum en = CalEnum.getByCode(code);
        if(null == en){
            return 0; // 实际上这里应该是抛出异常
        }

        int result = 0;

        switch (en){
            case ADD:
                result = add(num1,num2);
                break;
            case SUB:
                result = sub(num1,num2);
                break;
            case MUL:
                result = mul(num1,num2);
                break;
            case DIV:
                result = div(num1,num2);
                break;
            default:
                break;
        }
        return result;
    }

    private int add(int num1,int num2){
        return num1+num2;
    }

    private int sub(int num1,int num2){
        return num1-num2;
    }

    private int mul(int num1,int num2){
        return num1*num2;
    }

    private int div(int num1,int num2){
        return num1/num2;
    }

}
