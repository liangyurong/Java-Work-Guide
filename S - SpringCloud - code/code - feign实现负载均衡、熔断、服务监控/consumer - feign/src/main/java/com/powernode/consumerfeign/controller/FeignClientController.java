package com.powernode.consumerfeign.controller;

import com.powernode.consumerfeign.feign.FeignProviderClientInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("feign")
public class FeignClientController {

    @Autowired
    private FeignProviderClientInterface feignProviderClientInterface;

    @GetMapping("hello")
    public String hello(){
        return feignProviderClientInterface.hello();
    }

}
