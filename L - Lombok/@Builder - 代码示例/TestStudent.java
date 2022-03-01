package com.sdyb.mp.module.student;

import com.sdyb.mp.entity.Student;

public class TestStudent {


  public static void main(String[] args) {
      // 生成Studnet
      Student student = Student.builder()
              .id("1")
              .name("yurong333")
              .myEmail("qqemail")
              .build();
  }


}
