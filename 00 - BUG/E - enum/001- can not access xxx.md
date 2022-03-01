### can not access xxx

报错的地方：QuType.values()

报错信息：Cannot access com.sdyb.questionnaire.survey.enumentity.QuType

解决：有些项目报错，有些项目不报错，不知道怎么回事（显示错误的项目，重启之后就没报错了）

### 源码

```java
package com.sdyb.questionnaire.survey.enumentity;

/**
 * 枚举类。此类在生成问卷的时候用到。
 *
 * 目前只使用到单选题，多选题，单项填空题
 */
public enum QuType {

    RADIO("0","单选题"),
    CHECKBOX("1","多选题"),
    SINGLEFILL("2","单项填空题"),
    MULTIPLEFILL("3","多项填空题"),
    YESNO("4","是非题");

    private  String quTypeCode;
    private  String  quType;


    QuType(String quTypeCode,String quType){
        this.quTypeCode=quTypeCode;
        this.quType=quType;
    }

    public  String getQuType() {
        return this.quType;
    }

    public  String getQuTypeCode() {
        return this.quTypeCode;
    }

    /**
     * 通过类型获得实体
     */
    public static QuType getQuTypeByquType(String quType){
        for(QuType singleEnum:QuType.values()){
            if(quType.equals(singleEnum.getQuType())){
                return singleEnum;
            }
        }
        return null;
    }

    /**
     * 通过quTypeCode获得实体
     */
    public static QuType getQuTypeByQuTypeCode(String quTypeCode){
        for(QuType singleEnum:QuType.values()){
            if(quTypeCode.equals(singleEnum.getQuTypeCode())){
                return singleEnum;
            }
        }
        return null;
    }

}

```
