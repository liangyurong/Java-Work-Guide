package com.powernode.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("testRibbon")
    public String testRibbon(String serviceName){
        String result = restTemplate.getForObject("http://" + serviceName + "/hello", String.class);
        return result;
    }



}
