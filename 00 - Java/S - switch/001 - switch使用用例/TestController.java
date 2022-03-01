package com.sdyb.mp.module.myswitch;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/test/{type}")
    public void test(@PathVariable String type) {

        // 一般我们可以在前端拿到type，于是我们可以根据type获取到一个enum实体类，然后在switch中进行比较

        Week week = Week.getByType(type);
        switch (week){
            case MONDAY:
                System.out.println(week.getCode()+"今天周1，上班");
                break;
            case TUESDAY:
                System.out.println(week.getCode()+"今天周2，认真工作");
                break;
            case WEDNESDAY:
                System.out.println(week.getCode()+"今天周3，摸鱼");
                break;
            case THURSDAY:
                System.out.println(week.getCode()+"今天周4，用尽了洪荒之力");
                break;
            case FRIDAY:
                System.out.println(week.getCode()+"今天周5，放假");
                break;
            case SATURDAY:
                System.out.println(week.getCode()+"今天周6，睡懒觉");
                break;
            case SUNDAY:
                System.out.println(week.getCode()+"今天周7，做家务");
                break;
            default:
                break;
        }

    }
}
