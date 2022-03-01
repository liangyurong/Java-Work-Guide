package com.lyr.demo.controller;

import com.lyr.demo.entity.People;
import com.lyr.demo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class PeopleController {

    @Autowired
    private PeopleService pService;

    // http://localhost:9099/getPeopleByPageAndSize?page=1&size=3
    /** 第n页的m条记录，page从第1页算起
     *  分页查询，可以应用于无条件查询
     */
    @GetMapping("/getPeopleByPageAndSize")
    public List<People> getPeopleByPageAndSize(@RequestParam(value = "page") Integer page, @RequestParam("size") Integer size) {
        return pService.getPeopleByPageAndSize(page,size);
    }

    /** 单条件分页查询：根据姓名和邮箱获取people
     *
     *  分页查询，可以应用于单条件查询
     * */
    @GetMapping("/getPeopleByPageAndSizeAndName")
    public List<People> getPeopleByPageAndSizeAndName(@RequestParam(value = "page") Integer page,
                                                      @RequestParam("size") Integer size,
                                                      @RequestParam(value = "name") String name) {
        return pService.getPeopleByPageAndSizeAndName(page,size,name);
    }

    /** 双条件查询：根据姓名和邮箱获取people */
    @GetMapping("/getPeopleByPageAndSizeAndNameAndMyEmail")
    public List<People> getPeopleByPageAndSizeAndNameAndMyEmail(@RequestParam(value = "page") Integer page,
                                                                @RequestParam("size") Integer size,
                                                                @RequestParam(value = "name") String name,
                                                                @RequestParam(value = "myEmail") String myEmail) {
        return pService.getPeopleByPageAndSizeAndNameAndMyEmail(page,size,name,myEmail);
    }

    /** 多条件查询：根据姓名、邮箱、地址获取people */
    @GetMapping("/getPeopleByPageAndSizeAndNameAndMyEmailAndAddress")
    public List<People> getPeopleByPageAndSizeAndNameAndMyEmailAndAddress(@RequestParam(value = "page") Integer page,
                                                                          @RequestParam("size") Integer size,
                                                                          @RequestParam(value = "name") String name,
                                                                          @RequestParam(value = "myEmail") String myEmail,
                                                                          @RequestParam(value = "address") String address) {
        return pService.getPeopleByPageAndSizeAndNameAndMyEmailAndAddress(page,size,name,myEmail,address);
    }

}
