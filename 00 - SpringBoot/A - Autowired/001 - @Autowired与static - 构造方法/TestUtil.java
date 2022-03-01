package com.sdyb.mp.module.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 通用工具中使用组件
 */
// 一定要使用@Component
@Component
public class TestUtil {

    private static MyCom myCom;

    @Autowired
    public TestUtil(MyCom myCom){
        TestUtil.myCom = myCom;
    }

    public static String test(){
       return TestUtil.myCom.hi();
    }

}
