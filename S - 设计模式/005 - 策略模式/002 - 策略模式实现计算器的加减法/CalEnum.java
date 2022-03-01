package com.sdyb.mp.module.策略模式实现计算器;

public enum CalEnum {
    ADD(0,"加法"),
    SUB(1,"减法"),
    MUL(2,"乘法"),
    DIV(3,"除法");

    private int code;
    private String type;

    CalEnum(int code, String type){
        this.code=code;
        this.type=type;
    }

    public int getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    /**
     * @param type
     * @return 根据type返回对应的实体
     */
    public static CalEnum getByType(String type){
        for(CalEnum en : CalEnum.values()){
            if(type.equals(en.getType())){
                return en;
            }
        }
        return null;
    }

    /**
     * @param code
     * @return 根据code返回对应的实体
     */
    public static CalEnum getByCode(int code){
        for(CalEnum en : CalEnum.values()){
            if(code == en.getCode()){
                return en;
            }
        }
        return null;
    }

}

