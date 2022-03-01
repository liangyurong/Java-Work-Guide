package com.lyr.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyr.demo.entity.People;

import java.util.Optional;

public interface PeopleService extends IService<People> {

    Optional<People> findPeopleById(String id);

}
