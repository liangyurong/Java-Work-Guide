package com.lyr.demo.decorate;

public class Single {


    /**
     * 静态的全局变量
     */
    private static Single instance;

    /**
     * 构造器私有化
     */
    private Single(){
        System.out.println("创建了single对象");
    }

    /**
     * 提供一个外部能够访问Single对象的方法
     * @return single对象
     */
    public static Single getInstance(){
        // 保证了构造器只被调用了一次
        if(null == instance){
            instance = new Single();
        }
        return instance;
    }


}
