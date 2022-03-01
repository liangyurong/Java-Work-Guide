package com.sdyb.mp.module.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestUtil {

    private static MyCom staticMyCom;

    @Autowired
    private MyCom myCom;

    // 把非静态变量给到静态变量
    @PostConstruct
    public void beforeInit(){
        staticMyCom = this.myCom;
    }

    public static String test(){
       return staticMyCom.hi();
    }

}
