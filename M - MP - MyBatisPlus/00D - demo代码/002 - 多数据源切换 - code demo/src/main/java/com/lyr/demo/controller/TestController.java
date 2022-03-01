package com.lyr.demo.controller;

import com.lyr.demo.entity.People;
import com.lyr.demo.entity.Student;
import com.lyr.demo.service.PeopleService;
import com.lyr.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class TestController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private PeopleService peopleService;

    @GetMapping("/getp")
    @ResponseBody
    public Optional<People> getp(){
        Optional<People> personById = peopleService.findPeopleById("1");
        return personById;
    }

    @GetMapping("/gets")
    @ResponseBody
    public Optional<Student> gets(){
        Optional<Student> studentById = studentService.findStudentById("1");
        return studentById;
    }
}
