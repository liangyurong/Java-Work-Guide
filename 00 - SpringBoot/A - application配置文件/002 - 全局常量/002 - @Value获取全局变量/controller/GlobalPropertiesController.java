package com.sdyb.mp.controller;

import com.sdyb.mp.config.GlobalPropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalPropertiesController {

    @Autowired
    private GlobalPropertiesConfig globalPropertiesConfig;

    /**
     * 请求地址：http://localhost:8888/getGlobalProperties
     * @return name+age
     */
    @GetMapping("getGlobalProperties")
    public String getGlobalPropertiesConfig(){
        return globalPropertiesConfig.getName()+" "+ globalPropertiesConfig.getAge();
    }

}
