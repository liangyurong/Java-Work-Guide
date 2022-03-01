package com.sdyb.mp.controller;

import com.sdyb.mp.job.MyForTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForTestController {

    @Autowired
    private MyForTest forTest;

    @GetMapping("test")
    public void forTest(){
        for (int i = 0; i < 10; i++) {
            forTest.printTest(i);
        }
    }

}
