package com.demo.设计模式.策略模式.计算器_纯策略模式;

public enum CalType {
    ADD(0),
    SUB(1),
    MUL(2),
    DIV(3);

    private int type;

    CalType(int type){
        this.type=type;
    }

    public int getType() {
        return type;
    }

    public static CalType getCalTypeByType(int type){
        for(CalType en : CalType.values()){
            if(type == en.getType()){
                return en;
            }
        }
        return null;
    }
}
