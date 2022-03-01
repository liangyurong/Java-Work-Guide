package com.lyr.demo.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyr.demo.dao.StudentDao;
import com.lyr.demo.entity.Student;
import com.lyr.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements StudentService  {

    @Autowired
    private StudentDao studentDao;


    @DS("db1") //不使用@DS("db1") 也是可以的。因为设置了默认的主数据库是db1。没有设置就默认使用db1
    @Override
    public Optional<Student> findStudentById(String id) {
        Student student = studentDao.findStudentById(id);
        return Optional.ofNullable(student);
    }
}
