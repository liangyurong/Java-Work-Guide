package com.sdyb.mp.module.ioc;

import org.springframework.stereotype.Component;

/**
 * 被使用的组件
 */
@Component
public class MyCom {

    public String hi(){
        return "hi";
    }

}
