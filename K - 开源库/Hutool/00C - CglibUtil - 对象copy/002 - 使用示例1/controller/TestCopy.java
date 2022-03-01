package com.sdyb.mp.module.hutool.controller;


import cn.hutool.extra.cglib.CglibUtil;
import com.sdyb.mp.dto.StudentDto;
import com.sdyb.mp.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/copy")
public class TestCopy {

    // 多的一方复制给少的一方
    @GetMapping("testCopy")
    public String testCopy(){
        Student s = new Student("1","1","1");
        StudentDto dto = CglibUtil.copy(s, StudentDto.class);
        return dto.getName()+" "+dto.getMyEmail();
    }

    // 少的一方复制给多的一方
    @GetMapping("testCopy1")
    public String testCopy1(){
        StudentDto dto = new StudentDto("1","1");;
        Student s = CglibUtil.copy(dto, Student.class);
        return s.getName()+" "+s.getMyEmail();
    }

}
