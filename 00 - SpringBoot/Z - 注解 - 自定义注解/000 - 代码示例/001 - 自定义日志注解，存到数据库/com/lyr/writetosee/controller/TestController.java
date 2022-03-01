package com.lyr.writetosee.controller;

import com.lyr.writetosee.annotation.AutoLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;

@RestController
public class TestController {

    @AutoLog(value = "这是一个接口")
    @GetMapping("/hi")
    public String sayHi()  {
        return "返回了hi";
    }

}
