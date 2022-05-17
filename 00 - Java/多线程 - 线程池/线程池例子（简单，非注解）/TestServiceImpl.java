package com.lyr.demo.service.impl;

import com.lyr.demo.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public void  sout(String num) throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("现在输出的num是================"+num);
    }
}
