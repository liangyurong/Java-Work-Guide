package com.powernode.providera.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ProviderController {

    @GetMapping("hello")
    public String test(){

        new ArrayList<>();

       return "这是provider AAA的接口";
    }

}
