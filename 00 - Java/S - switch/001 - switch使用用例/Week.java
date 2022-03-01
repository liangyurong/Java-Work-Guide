package com.sdyb.mp.module.myswitch;

public enum Week {
    MONDAY(0,"星期一"),
    TUESDAY(1,"星期二"),
    WEDNESDAY(2,"星期三"),
    THURSDAY(3,"星期四"),
    FRIDAY(4,"星期五"),
    SATURDAY(5,"星期六"),
    SUNDAY(6,"星期日");

    private int code;
    private String type;

    Week(int code, String type){
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
    public static Week getByType(String type){
        for(Week week : Week.values()){
            if(type.equals(week.getType())){
                return week;
            }
        }
        return null;
    }

    /**
     * @param code
     * @return 根据code返回对应的实体
     */
    public static Week getByCode(int code){
        for(Week week : Week.values()){
            if(code == week.getCode()){
                return week;
            }
        }
        return null;
    }

}
