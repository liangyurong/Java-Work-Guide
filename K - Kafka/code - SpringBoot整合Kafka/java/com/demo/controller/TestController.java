package com.demo.controller;

import com.demo.producer.KafkaProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private KafkaProducer producer;

    @GetMapping("send")
    public String send(String msg){
        producer.send("springboot_kafka",msg);
        return "producer send msg successful";
    }
}
