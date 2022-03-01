package com.sdyb.mp.module.ioc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 测试
@RestController
public class TestController {

    @GetMapping("/ioc")
    public String test(){
        return TestUtil.test();
    }

}
