package com.powernode.providerb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @GetMapping("hello")
    public String test(){
       return "这是provider BBB的接口";
    }

}
