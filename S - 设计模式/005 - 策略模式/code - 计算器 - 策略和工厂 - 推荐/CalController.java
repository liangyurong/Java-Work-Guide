package com.demo.设计模式.策略模式.计算器_策略和工厂;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalController {

    @Autowired
    private CalService service;

    // http://localhost:9090/cal?inputVal=div
    @GetMapping("cal")
    public int cal(@RequestParam String inputVal){
       return service.select(inputVal);
    }

}
