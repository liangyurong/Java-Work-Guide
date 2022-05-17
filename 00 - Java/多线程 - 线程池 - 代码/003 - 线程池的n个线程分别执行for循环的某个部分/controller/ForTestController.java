package com.sdyb.mp.controller;

import com.sdyb.mp.job.MyTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForTestController {

    @Autowired
    private MyTask myTask;

    @GetMapping("test")
    public void forTest(){
        for (int i = 0; i < 10; i++) {
            myTask.printTest(i);
        }
    }

}
