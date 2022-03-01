```jshelllanguage
package com.sdyb.mp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sdyb.mp.dto.StudentDto;
import com.sdyb.mp.entity.Student;
import com.sdyb.mp.exception.MpException;
import com.sdyb.mp.mapper.StudentMapper;
import com.sdyb.mp.service.StudentService;
import com.sdyb.mp.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author lyr
 * @since 2021-11-29
 */
@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentService studentService;

    /**
     * MP自带：根据id获取到对象
     * @param id id
     * @return result
     */
    @GetMapping("/find")
    public Result getById(@RequestParam("id")String id){

        Result result = new Result();

        Student entity = studentService.getById(id);
        
        // 找不到对象，就抛出异常
        if(null == entity){
            throw new MpException("找不到对象");
        }

        int code = null==entity ? 1 :0;
        String msg = code==0 ? "根据id获取到对象":"根据id获取不到对象";

        result.putCode(code);
        result.putMsg(msg);
        result.putData(entity);

        return result;
    }





}


```
