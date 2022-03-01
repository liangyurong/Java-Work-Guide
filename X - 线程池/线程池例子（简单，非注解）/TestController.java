package com.lyr.demo.controller;

import com.lyr.demo.service.SyncRunTaskService;
import com.lyr.demo.util.ThreadPoolUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/tt")
    public void tt(@RequestParam("num") String num) {
        // 线程池执行任务
        ThreadPoolUtil.getThreadPoolTaskExecutor().execute(new SyncRunTaskService(num));
    }

}
