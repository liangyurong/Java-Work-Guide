package com.lyr.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyr.demo.entity.Student;
import java.util.Optional;

public interface StudentService extends IService<Student> {

    Optional<Student> findStudentById(String id);

}
