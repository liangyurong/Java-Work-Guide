package com.lyr.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyr.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface StudentDao extends BaseMapper<Student> {

    List<Student> selectByEmail();

    Student findStudentById(String id);

}
